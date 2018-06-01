package com.example.davids.minitabletapp.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.IntentCompat;
import android.view.WindowManager;


import com.example.davids.minitabletapp.Helpers.MyCallback;
import com.example.davids.minitabletapp.Helpers.TimeHelper;
import com.example.davids.minitabletapp.R;
import com.example.davids.minitabletapp.fragments.BaseFragment;
import com.example.davids.minitabletapp.logics.Consts;
import com.example.davids.minitabletapp.logics.network.NearVisionServer;

import java.io.IOException;

public abstract class BaseActivity extends FragmentActivity
{
	protected BaseFragment _currentFragment;

	private NearVisionServer _nvServer;


	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		_nvServer = new NearVisionServer();


	}

	public void replaceFragment(Class<? extends BaseFragment> baseFragment, Bundle b)
	{
		replaceFragment(R.id.fragment_container, baseFragment, b);
	}

	public String getVersionName()
	{
		String version = getVersion();
		String versionName = String.format(getString(R.string.splash_version_name), version);
		return versionName;
	}

	protected void initApplication()
	{



		
		_nvServer.initDataStructures();//init strings from the language files
		
	}

	public String getVersion()
	{
		PackageManager manager = getPackageManager();
		PackageInfo info;
		String versionName = "";
		try
		{
			info = manager.getPackageInfo(getPackageName(), 0);
			versionName = info.versionName;
		}
		catch (NameNotFoundException e)
		{
			e.printStackTrace();
		}
		return versionName;
	}

	public void changeScreenBrightness(int brightnessLevel)
	{
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		getWindow().getAttributes().screenBrightness = brightnessLevel;
		getWindow().setAttributes(lp);
		Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightnessLevel);
	}

	public void replaceFragment(int frameContainerId, Class<? extends BaseFragment> fragClass, Bundle b)
	{
		BaseFragment bf = null;
		try
		{
			bf = (BaseFragment) fragClass.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();

		if (manager.getBackStackEntryCount() == 0)//splash - first fragment 
		{
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		}
		else
		{
			ft.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_right, R.anim.slide_out_to_left);
		}
	
//		if(!_currentFragment.getClass().getSimpleName().equals(bf.getClass().getSimpleName()))
		{
			_currentFragment = bf;
			_nvServer.setResponseListener(_currentFragment);
			ft.replace(frameContainerId, bf, bf.getClass().getSimpleName());
			ft.addToBackStack(bf.getClass().getSimpleName());
			ft.commitAllowingStateLoss();
		}
	}

	protected boolean hasOnlySplash()
	{
		FragmentManager manager = getSupportFragmentManager();

		int numFrags = manager.getBackStackEntryCount();

		return numFrags <= 2;//splash 		
	}

	public void popCurrentFragment()
	{

		BaseFragment prevFragment = getPreviousFragment();
		FragmentManager sfm = getSupportFragmentManager();
		sfm.popBackStackImmediate();

		_currentFragment = prevFragment;

	}

	public BaseFragment getPreviousFragment()
	{
		BaseFragment previousFrag = null;

		FragmentManager manager = getSupportFragmentManager();
		int previousIndex = manager.getBackStackEntryCount() - 2;

		if (previousIndex >= 0)
		{
			BackStackEntry previuosEntry = manager.getBackStackEntryAt(previousIndex);
			previousFrag = (BaseFragment) manager.findFragmentByTag(previuosEntry.getName());
		}

		return previousFrag;
	}
	


	@Override
	protected void onResume() {
		super.onResume();
		startNvServer();
	}
	
	private void startNvServer() {
		try
		{
			_nvServer.start();
			_nvServer.setResponseListener(_currentFragment);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String generateServerResponse(Consts.L40Cmd cmd){
		return _nvServer.generateResponse(cmd);
	}
	


	@Override
	protected void onPause() {
		super.onPause();
		_nvServer.stop();
	}

	public void restartApp() {
		TimeHelper.intTimer(300, new MyCallback() {
			@Override
			public void onSuccess(String response) {
				PackageManager packageManager = getPackageManager();
				Intent intent = packageManager.getLaunchIntentForPackage(getPackageName());
				ComponentName componentName = intent.getComponent();
				Intent mainIntent = IntentCompat.makeRestartActivityTask(componentName);
				mainIntent.putExtra("app_restarting", true);
				//PrefUtils.putBoolean("app_restarting", true);
				startActivity(mainIntent);
				System.exit(0);
			}
		});

	}
}
