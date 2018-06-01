package com.example.davids.minitabletapp.fragments;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.davids.minitabletapp.Helpers.PrefHelper;
import com.example.davids.minitabletapp.Helpers.WifiHelper;
import com.example.davids.minitabletapp.R;

import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;

public class SplashFragment extends BaseFragment implements OnClickListener
{
	private TextView _versionText;
	private Button _openMaintenanceBtn;
	private Button _forceOpenBtn;
	private Runnable _splashRunnable;
	private Spinner vxLanSpinner;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.splash_fragment, container, false);

		initViews(view);

		initListeners();
		initHandler();

		conectToWifi();
		
		return view;
	}

	public void conectToWifi() {
		WifiHelper wifiHelper =new WifiHelper(getActivity());
		if (wifiHelper.isWifiEnabled()) {
			try {
				if (wifiHelper.isConnectToWifi(PrefHelper.getVxLan()))
                    _splashRunnable = new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            getBaseActivity().replaceFragment(NearVisionFragment.class, null);
                        }
                    };
                else {
                    if (wifiHelper.connectToWifi(PrefHelper.getVxLan())) {
                        if (wifiHelper.isConnectToWifi(PrefHelper.getVxLan()))
                            _splashRunnable = new Runnable() {
                                @Override
                                public void run() {

                                    getBaseActivity().replaceFragment(NearVisionFragment.class, null);
                                }

                            };
                    }else {

                    }
                }
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (java.lang.InstantiationException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}else {
			Log.w("WifiHelper","wifi is not Connected");
		}
	}

	@Override
	public void onResume()
	{
		super.onResume();
		_handler.postDelayed(_splashRunnable, 2000);
	}

	@Override
	public void onPause()
	{
		_handler.removeCallbacks(_splashRunnable);
		super.onPause();
	}

	@Override
	protected void initViews(View view)
	{

		_versionText = (TextView) view.findViewById(R.id.version_text);
		_openMaintenanceBtn = (Button) view.findViewById(R.id.open_maintenance);
		_forceOpenBtn = (Button) view.findViewById(R.id.force_open);
		vxLanSpinner = (Spinner) view.findViewById(R.id.vxLanSpinner);
		PackageManager manager = getActivity().getPackageManager();
		PackageInfo info;
		try
		{
			info = manager.getPackageInfo(getActivity().getPackageName(), 0);
			String version = info.versionName;
			String versionName = String.format(getString(R.string.splash_version_name), version);
			_versionText.setText(versionName);
		}
		catch (NameNotFoundException e)
		{
			e.printStackTrace();
		}
		ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
				R.array.vxlan_list, R.layout.item_spinner_map);

		adapter.setDropDownViewResource(R.layout.item_spinner_dropdown_map);
		vxLanSpinner.setAdapter(adapter);
		vxLanSpinner.setSelection(getVXLanPosition(PrefHelper.getVxLan()   ));

		vxLanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				 if (position==0){
					 PrefHelper.setVxLan("Other" );

				 } if (position==1){
					PrefHelper.setVxLan("VXLAN" );
 				}else {
					 PrefHelper.setVxLan("VXLAN"+(position-1));

				 }
			 conectToWifi();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}
	public int getVXLanPosition(String item){

		switch (item){
			case "Other":

				return 0;

			case "VXLAN":
				return 1;
			case "VXLAN1":
				return 2;

			case "VXLAN2":
				return 3;

			case "VXLAN3":
				return 4;

			case "VXLAN4":
				return 5;

			case "VXLAN5":
				return 6;

			case "VXLAN6":
				return 7;

			case "VXLAN7":
				return 8;

			case "VXLAN8":
				return 9;

			case "VXLAN9":
				return 10;

		}
		return 0;
	}
	@Override
	protected void initListeners()
	{
		_openMaintenanceBtn.setOnClickListener(this);
		_forceOpenBtn.setOnClickListener(this);
	}

	@Override
	protected void initHandler()
	{
		_handler = new Handler();

	}

	
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.open_maintenance:
				getBaseActivity().replaceFragment(SettingsFragment.class, null);
				break;
			case R.id.force_open:
				getBaseActivity().replaceFragment(NearVisionFragment.class, null);
				break;
		}
	}

	@Override
	public void showUI()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideUI()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initData()
	{
		// TODO Auto-generated method stub
		
	}


	
}
