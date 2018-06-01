package com.example.davids.minitabletapp.logics;

import com.example.davids.minitabletapp.NearVisionApplication;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FileManager
{

	private static FileManager	_fileManager;
	private File _languagesDir;

	private FileManager()
	{
		_languagesDir = new File(Consts.FILE_BASE_PATH + Consts.LANGUAGES_DIR);
	}

	public static FileManager getInstance()
	{
		if (_fileManager == null)
		{
			synchronized (FileManager.class)
			{
				_fileManager = new FileManager();
			}
		}

		return _fileManager;
	}

	//file name has to be with path
	public String readFile(String fileName)
	{
		StringBuilder stringBuilder = new StringBuilder();
		try
		{
			FileReader langFile = new FileReader(fileName);
			BufferedReader in = new BufferedReader(langFile);
			String line;

			while ((line = in.readLine()) != null)
			{
				stringBuilder.append(line + "\n");
			}

			in.close();
			langFile.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public boolean isFileExists(String filePath)
	{
		File f = new File(filePath);
		return f.exists();
	}

	public void createDirectories(String dirs)
	{
		File f = new File(dirs);
		if (!f.exists())
		{
			f.mkdirs();
		}
	}

	public void deleteLanguageDir()
	{
		deleteRecursive(_languagesDir);
	}

	private void deleteRecursive(File fileOrDirectory)
	{
		if (fileOrDirectory.isDirectory())
		{
			for (File child : fileOrDirectory.listFiles())
				deleteRecursive(child);
		}
		fileOrDirectory.delete();
	}

	public String readFromStream(InputStream stream)
	{
		InputStreamReader inputStreamReader = new InputStreamReader(stream);
		BufferedReader in = new BufferedReader(inputStreamReader);
		StringBuilder builder = new StringBuilder();
		try
		{

			String line;
			while ((line = in.readLine()) != null)
			{
				builder.append(line + "\n");
			}
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return builder.toString();
	}

	public String readRawFile(int fileResource)
	{
		InputStream inputStream = NearVisionApplication.getContext().getResources().openRawResource(fileResource);
		String res = readFromStream(inputStream);
		return res;
	}

	public InputStream readRawFileToStream(int fileResource)
	{
		InputStream inputStream = NearVisionApplication.getContext().getResources().openRawResource(fileResource);
		return inputStream;
	}
	
	public void writeToFileFromInputStream(String fileName, InputStream stream)
	{
		InputStreamReader inputStreamReader = new InputStreamReader(stream);
		BufferedReader in = new BufferedReader(inputStreamReader);
		try
		{
			String line;
			FileOutputStream f = new FileOutputStream(fileName,false);
			PrintWriter pw = new PrintWriter(f);
			while ((line = in.readLine()) != null)
			{
				pw.append(line + "\n");
			}
			pw.flush();
			pw.close();
			f.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void writeToFile(String fileName, String data)
	{
		OutputStream myOutput;
		try
		{
			myOutput = new BufferedOutputStream(new FileOutputStream(fileName, false));
			myOutput.write(data.getBytes());
			myOutput.flush();
			myOutput.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public boolean hasLanguageDir()
	{
		return hasDir(_languagesDir.getPath());
	}

	public boolean hasDir(String pathStr)
	{
		File path = new File(pathStr);
		return path.exists();
	}

	public void createLanguageDir()
	{
		_languagesDir.mkdirs();
	}

	//	private void writeLanguagesToFile(String languagePrefix) {
	//		int langResource = getResourceId(languagePrefix, "raw");
	//		String fileName = _languagesDir.getPath()+"/"+languagePrefix+".lang";
	////		writeFileToExternalStorage(fileName, langResource);
	//		InputStream inputStream = VisionApplication.getContext().getResources().openRawResource(langResource);
	//	}

}
