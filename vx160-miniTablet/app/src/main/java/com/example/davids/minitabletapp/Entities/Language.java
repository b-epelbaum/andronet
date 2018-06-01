package com.example.davids.minitabletapp.Entities;

import com.google.gson.Gson;

public class Language
{

	private String _langPrefix;
	private String _langName;
	private String _langCode;

	public Language(String langPrefix, String langName, String langCode)
	{
		_langPrefix = langPrefix;
		_langName = langName;
		_langCode = langCode;
	}

	public void setLangCode(String langCode)
	{
		_langCode = langCode;
	}

	public String getLangCode()
	{
		return _langCode;
	}

	public String getLangPrefix()
	{
		return _langPrefix;
	}

	public void setLangPrefix(String langPrefix)
	{
		_langPrefix = langPrefix;
	}

	public String getLangName()
	{
		return _langName;
	}

	public void setLangName(String langName)
	{
		_langName = langName;
	}
	@Override
	public String toString()
	{
		return  new Gson().toJson(this);
	}
}
