package com.example.davids.minitabletapp.logics;

import com.example.davids.minitabletapp.logics.network.SharedPreferencesManager;


public class Logics
{

	private static Logics					_logics;
	private static SharedPreferencesManager	_shManager;
	private static FileManager				_fileManager;
	private static LanguageManager			_langManager;
	
	private Logics()
	{

	}

	public static Logics getInstance()
	{
		synchronized (Logics.class) {
			if (_logics == null)
			{
				_logics = new Logics();
				_shManager = SharedPreferencesManager.getInstance();
				_fileManager = FileManager.getInstance();
				_langManager = LanguageManager.getInstance();
			}
		}
		return _logics;
	}

	
	public FileManager getFileManager()
	{
		return _fileManager;
	}

	public SharedPreferencesManager getSharedPrefsManager()
	{
		return _shManager;
	}

	public LanguageManager getLanguageManager()
	{
		return _langManager;
	}

}
