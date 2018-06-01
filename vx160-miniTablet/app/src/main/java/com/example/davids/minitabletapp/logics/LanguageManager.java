package com.example.davids.minitabletapp.logics;

import com.example.davids.minitabletapp.Entities.Language;
import com.example.davids.minitabletapp.NearVisionApplication;
import com.example.davids.minitabletapp.R;
import com.example.davids.minitabletapp.logics.network.SharedPreferencesManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class LanguageManager
{
	private static final String LANGUAGES_FILE_NAME	= "languages";
	private static final String LANGUAGE_POSTFIX	= ".lang";

	private static LanguageManager		_langManager;
	private List<Language> _supportedLanguages;
	private FileManager					_fileManager;
	private Map<String,List<String>> _langTranslations;
	private String _languagesDir;
	private Language					_currnetLanguage;

	public static final String DEFAULT_LANGUAGE_PREFIX = "en_gb";
	
	private LanguageManager()
	{
		_langTranslations = new Hashtable<String,List<String>>();
		_languagesDir = Consts.FILE_BASE_PATH + Consts.LANGUAGES_DIR;
		_fileManager = Logics.getInstance().getFileManager();
	}

	public void initLanguages(String language)
	{
		if (!_fileManager.hasLanguageDir())
		{
			_fileManager.createLanguageDir();
			saveLanguagesToExternalStorage();
		}
		else
		{
			//need to check timestamp of the languages maybe need to replace translations
			long origianlTranslationsTimestamp = Logics.getInstance().getSharedPrefsManager().getLong(SharedPreferencesManager.LANGUAGES_UPDATED_DATE_KEY, Consts.DEFAULT_UPDATED_LANGUAGES_DATE);
			long currentTranslationsTimestamp = getCurrentTranslationsTimestamp();
			if(origianlTranslationsTimestamp<currentTranslationsTimestamp)
			{
				saveLanguagesToExternalStorage();
				
				//update the current time stamp 
				Logics.getInstance().getSharedPrefsManager().putLong(SharedPreferencesManager.LANGUAGES_UPDATED_DATE_KEY, currentTranslationsTimestamp);
			}
		}
		
		initAppSupportedLanguages();
		setLanguage(language);
	}

	private long getCurrentTranslationsTimestamp()
	{
		long currentLangTimestamp = 0;
		try
		{
			String languagesData = Logics.getInstance().getFileManager().readRawFile(R.raw.languages);
			String timestampStr = languagesData.split("\n")[0];
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:SSS", Locale.US);
			Date transTimestamp = sdf.parse(timestampStr);
			currentLangTimestamp = transTimestamp.getTime();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return currentLangTimestamp;
	}

	private void initAppSupportedLanguages()
	{
		String supportedLanguages = _fileManager.readFile(_languagesDir + LANGUAGES_FILE_NAME);

		ArrayList<String> supportedLanguagesList = new ArrayList<String>(Arrays.asList(supportedLanguages.split("\n")));

		_supportedLanguages = new ArrayList<Language>();
		
		//first row is the timestamp of the translations
		for (int i=1;i<supportedLanguagesList.size();i++)
		{
			String lang = supportedLanguagesList.get(i);
			String[] langFrags = lang.split(" ");
			Language currentLang = new Language(langFrags[0], langFrags[1], langFrags[2]);
			_supportedLanguages.add(currentLang);
		}

	}

	private void saveLanguagesToExternalStorage()
	{
		InputStream inputStream = NearVisionApplication.getContext().getResources().openRawResource(R.raw.languages);
		String supportedLanguages = _fileManager.readFromStream(inputStream);
		_fileManager.writeToFile(_languagesDir + LANGUAGES_FILE_NAME, supportedLanguages);

		ArrayList<String> supportedLanguagesList = new ArrayList<String>(Arrays.asList(supportedLanguages.split("\n")));
		for (int i=1;i<supportedLanguagesList.size();i++)
		{
			String lang = supportedLanguagesList.get(i);
			String languagePrefix = lang.split(" ")[0];
			int languageResource = getResourceId(languagePrefix, "raw");
			InputStream languageStream = NearVisionApplication.getContext().getResources().openRawResource(languageResource);
			_fileManager.writeToFileFromInputStream(_languagesDir + File.separator + languagePrefix + LANGUAGE_POSTFIX, languageStream);
		}
	}
	
	
	public List<String> getTranslationArray(String key)
	{
		return _langTranslations.get(key);
	}
	
	public String getTranslation(String key)
	{
		String translation=null;
		try
		{
			translation = _langTranslations.get(key).get(0);
		}
		catch (Exception e)
		{
			translation = null;
		}
		return translation;
	}

	public static LanguageManager getInstance()
	{
		if (_langManager == null)
		{
			synchronized (LanguageManager.class)
			{
				_langManager = new LanguageManager();
			}
		}

		return _langManager;
	}

	private int getResourceId(String pVariableName, String pResourcename)
	{
		String packageName = NearVisionApplication.getContext().getPackageName();
		try
		{
			return NearVisionApplication.getContext().getResources().getIdentifier(pVariableName, pResourcename, packageName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}

	public void setLanguage(String languagePrefix)
	{
		String languageDataPath = _languagesDir + File.separator + languagePrefix + LANGUAGE_POSTFIX;

		//checking if the translation file exists, if not default language would be set(english)
		if (!_fileManager.isFileExists(languageDataPath))
		{
			languageDataPath = _languagesDir + File.separator+DEFAULT_LANGUAGE_PREFIX+ LANGUAGE_POSTFIX;
		}

		String langData = _fileManager.readFile(languageDataPath);

		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(langData));
			Document doc = builder.parse(is);
			
			insertTranslations(doc);
			
			//setting the current language of application(lang object)
			for (Language lang : _supportedLanguages)
			{
				if (lang.getLangPrefix().equals(languagePrefix))
				{
					_currnetLanguage = lang;
					break;
				}
			}
			
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
	}

	private void insertTranslations(Document doc)
	{
		Element translationsRoot = (Element) doc.getElementsByTagName("resources").item(0);
		NodeList nodeList = translationsRoot.getChildNodes();
	    for (int i = 0; i < nodeList.getLength(); i++)
	    {
	        Node currentNode = nodeList.item(i);
	        if (currentNode.getNodeType() == Node.ELEMENT_NODE)
	        {
	        	Node translatedNode = currentNode.getAttributes().getNamedItem("name");
	        	 String translationStrKey = translatedNode.getNodeValue();
	 			_langTranslations.put(translationStrKey, new ArrayList<String>());
	 			
	        	if(currentNode.getNodeName().equals("string"))
	        	{
        			_langTranslations.get(translationStrKey).add(currentNode.getTextContent());
	        	}
	        	else if(currentNode.getNodeName().equals("string-array"))
	        	{
	        		NodeList translationList = currentNode.getChildNodes();
	        		for(int translationArrayIndex = 0;translationArrayIndex<translationList.getLength();translationArrayIndex++)
	        		{
	        			 Node currentTranslationNode = translationList.item(translationArrayIndex);
	        			 if(currentTranslationNode.getNodeType() == Node.ELEMENT_NODE)
	        			 {
	        				 String currentTranslation = currentTranslationNode.getTextContent();
	        				 _langTranslations.get(translationStrKey).add(currentTranslation);
	        			 }
	        		}
	        	}
	        }
	    }
	}

	public String getLanguageCode()
	{
		return _currnetLanguage.getLangCode();
	}

	public List<Language> getSupportedLanguages()
	{
		return _supportedLanguages;
	}

}
