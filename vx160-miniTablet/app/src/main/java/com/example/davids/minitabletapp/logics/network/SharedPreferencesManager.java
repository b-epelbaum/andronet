package com.example.davids.minitabletapp.logics.network;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.davids.minitabletapp.NearVisionApplication;

public class SharedPreferencesManager
{
	
	public static final String LANGUAGES_UPDATED_DATE_KEY 	= "LANGUAGES_UPDATED_DATE_KEY";
	public static final String SELECTED_NV_FUNCTION_KEY 	= "SELECTED_NV_FUNCTION_KEY";
	public static final String APP_LANGUAGE_KEY				= "APP_LANGUAGE_KEY";
	
	public static final String SELECTED_LANGUAGE_INDEX_KEY  = "SELECTED_LANGUAGE_INDEX_KEY";
	public static final String SELECTED_FIXATION_INDEX_KEY  = "SELECTED_FIXATION_INDEX_KEY";
	
	private static SharedPreferencesManager	_spManager;
	private SharedPreferences _prefs;

	private SharedPreferencesManager()
	{
		String pakageName = NearVisionApplication.getContext().getPackageName();
		_prefs = NearVisionApplication.getContext().getSharedPreferences(pakageName, Context.MODE_PRIVATE);
	}

	public static SharedPreferencesManager getInstance()
	{
		if (_spManager == null)
		{
			synchronized (SharedPreferencesManager.class)
			{
				_spManager = new SharedPreferencesManager();
			}
		}
		return _spManager;
	}

	public void putString(String key, String value)
	{
		_prefs.edit().putString(key, value).commit();
	}

	public void putBoolean(String key, boolean value)
	{
		_prefs.edit().putBoolean(key, value).commit();
	}

	public void putFloat(String key, float value)
	{
		_prefs.edit().putFloat(key, value).commit();
	}

	public void putInt(String key, int value)
	{
		_prefs.edit().putInt(key, value).commit();
	}

	public void putLong(String key, long value)
	{
		_prefs.edit().putLong(key, value).commit();
	}
	
	public String getString(String key, String defaultValue)
	{
		String value = null;

		try
		{
			value = _prefs.getString(key, defaultValue);
		}
		catch (Exception e)
		{
			value = defaultValue;
			e.printStackTrace();
		}

		return value;
	}

	public boolean getBoolean(String key, boolean defaultValue)
	{
		boolean value = false;
		try
		{
			value = _prefs.getBoolean(key, defaultValue);
		}
		catch (Exception e)
		{
			value = defaultValue;
		}

		return value;
	}

	public float getFloat(String key, float defaultValue)
	{
		float value = 0;
		try
		{
			value = _prefs.getFloat(key, defaultValue);
		}
		catch (Exception e)
		{
			value = defaultValue;
		}
		return value;
	}

	public int getInt(String key, int defaultValue)
	{
		int value = 0;
		try
		{
			value = _prefs.getInt(key, defaultValue);
		}
		catch (Exception e)
		{
			value = defaultValue;
		}
		return value;
	}

	public long getLong(String key, long defaultValue)
	{
		long value = 0;
		try
		{
			value = _prefs.getLong(key, defaultValue);
		}
		catch (Exception e)
		{
			value = defaultValue;
		}
		return value;
	}
}
