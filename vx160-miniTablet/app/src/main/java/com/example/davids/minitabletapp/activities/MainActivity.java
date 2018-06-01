package com.example.davids.minitabletapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

import com.example.davids.minitabletapp.R;
import com.example.davids.minitabletapp.fragments.DimFragment;
import com.example.davids.minitabletapp.fragments.NearVisionFragment;
import com.example.davids.minitabletapp.fragments.SplashFragment;
import com.example.davids.minitabletapp.logics.Consts;
import com.example.davids.minitabletapp.logics.receivers.PowerReceiver;


public class MainActivity extends BaseActivity implements OnTouchListener
{
	private static final int	DEFAULT_SCREEN_DELAY		= 1000;
	private static final int	DEFAULT_SCREEN_BRIGHTNESS	= 0;

	public static boolean 		_isRunning;


	private FrameLayout _fragmentContianer;
	private Handler _hideSoftKeysHandler;
	private Runnable _hideSoftKeysRunnable;
	
	private boolean 			_softKeysVisible;
//	private int 				_defaultScreenTimeout;
//	private int 				_defaultScreenBrightness;
	
//	private boolean				_isDimmed;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		_softKeysVisible = false;
		
		initApplication();
		
		_fragmentContianer = (FrameLayout) findViewById(R.id.fragment_container);
		_fragmentContianer.setOnTouchListener(this);
		
//		_isDimmed = false;
		initHandler();
		intentHandler();
		initData();
		
		Log.d("anton","onCreate");
	}

	//disable volume controll of the tablet while in the application
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event)
	{
		if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP))
        {
        	return true;
        }
		return super.onKeyDown(keyCode, event);
	}
	
	//disable volume controll of the tablet while in the application
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP))
        {
        	return true;
        }
		return super.onKeyDown(keyCode, event);
	}
	
	private void initData()
	{
		getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
              if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                _hideSoftKeysHandler.postDelayed(_hideSoftKeysRunnable, Consts.HIDE_SOFT_KEYS_TIMEOUT);
                _softKeysVisible = true;
                _currentFragment.showUI();
              }
              else
              {
            	  _currentFragment.hideUI();
            	  _softKeysVisible = false;
              }
            }

          });

		_isRunning = true;
//		_defaultScreenTimeout = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, DEFAULT_SCREEN_DELAY);
//		_defaultScreenBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, DEFAULT_SCREEN_BRIGHTNESS);
		replaceFragment(SplashFragment.class, null);

//
	}


	private void intentHandler()
	{
	
	}

	public synchronized boolean isSoftKeysVisible()
	{
		return _softKeysVisible;
	}

	private void initHandler()
	{
		_hideSoftKeysHandler = new Handler();
		_hideSoftKeysRunnable = new Runnable()
		{
			
			@Override
			public void run()
			{
				hideSoftKeys();
			}
		};
	}

	@Override
	protected void onNewIntent(Intent intent)
	{
		super.onNewIntent(intent);
		setIntent(intent);
		
		
		Bundle b = getIntent().getExtras();
//		Toast.makeText(this,"onNewIntent "+(b==null),Toast.LENGTH_LONG).show();
		if (b != null && b.containsKey(PowerReceiver.DIM_APP_KEY))
		{
			boolean isDimmed = b.getBoolean(PowerReceiver.DIM_APP_KEY);
//			Toast.makeText(this,"onNewIntent killApp="+isDimmed,Toast.LENGTH_LONG).show();
			if (isDimmed)
			{
//				_isDimmed = true;
				replaceFragment(DimFragment.class, null);
			}
			else
			{
				replaceFragment(NearVisionFragment.class, null);
			}
		}
		
		Log.d("anton","onNewIntent");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		hideSoftKeys();
		changeScreenBrightness(DEFAULT_SCREEN_BRIGHTNESS);
	}

//	@Override
//	public void onDetachedFromWindow()
//	{
//		super.onDetachedFromWindow();
//		Log.d("anton","onDetachedFromWindow");
//		if(!_isKilled)
//		{
//			Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, _defaultScreenBrightness);
//			Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, _defaultScreenTimeout);
//		}
//		else
//		{
//			changeScreenBrightness(0);
//			Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 15*1000);
//		}
//		
//	}
@Override
protected void onStop() {
	super.onStop();
	changeScreenBrightness(100);
}
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.d("anton","onDestroy");
		_isRunning = false;

	}
	
	@Override
	public void onBackPressed()
	{
		if (hasOnlySplash())
		{
			finish();
		}
		else
		{
			_currentFragment = getPreviousFragment();
			super.onBackPressed();
		}
	}
	
	public void hideSoftKeys()
	{
		 getWindow().getDecorView().setSystemUiVisibility(
		            		  View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
		                    | View.SYSTEM_UI_FLAG_FULLSCREEN); // hide status bar
	}

	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		switch (v.getId())
		{
			case R.id.fragment_container:
				Log.d("anton","fragment_container onTouch");
				_hideSoftKeysHandler.removeCallbacks(_hideSoftKeysRunnable);
				_hideSoftKeysHandler.postDelayed(_hideSoftKeysRunnable, Consts.HIDE_SOFT_KEYS_TIMEOUT);
				break;

		}
		return false;
	}
	

	
}
