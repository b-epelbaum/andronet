package com.example.davids.minitabletapp;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;


import com.example.davids.minitabletapp.Entities.StringText;
import com.example.davids.minitabletapp.Helpers.LocaleHelper;
import com.example.davids.minitabletapp.Helpers.PrefHelper;
import com.example.davids.minitabletapp.logics.Consts;

import java.util.ArrayList;

public class NearVisionApplication extends Application
{

	private static int				_screenWidth;
	private static int				_screenHeight;
	private static Context _context;

	public static int getCurrentTextParagraph() {
		return currentTextParagraph;
	}

	public static void setCurrentTextParagraph(int currentTextParagraph) {
		NearVisionApplication.currentTextParagraph = currentTextParagraph;
	}



	private static int	 currentTextParagraph;	//the index of the lower paragrph that will be shown in the bigger tablet

	public static String _changedLanguagePrefix;
	
	@Override
	public void onCreate()
	{
		super.onCreate();

		_context = this;
		 currentTextParagraph = Consts.NUMBER_TEXT_PARAGRAPHS;

		initData();
	}

	public static void initData() {
		LocaleHelper.setLocale(getContext(), PrefHelper.getLanguage());
		screenSizeInit();
		initText();
	}

	public static  void initText() {
		textArrayList=new ArrayList<StringText>();
		String string[]= getContext().getResources().getStringArray(R.array.nv_tablets_paragraphs);
		String unit[]=  getContext().getResources().getStringArray(R.array.unit);
		String fontSize[]=  getContext().getResources().getStringArray(R.array.font_size);
		textArrayList.add(new StringText(Float.valueOf(fontSize[8]),string[8],unit[8],"1"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[7]),string[7],unit[7],"2"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[6]),string[6],unit[6],"3"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[5]),string[5],unit[5],"4"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[4]),string[4],unit[4],"5"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[3]),string[3],unit[3],"6"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[2]),string[2],unit[2],"7"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[1]),string[1],unit[1],"8"));
		textArrayList.add(new StringText(Float.valueOf(fontSize[0]),string[0],unit[0],"9"));

	}
	public static Context getContext()
	{
		return _context;
	}
	public static ArrayList<StringText> getTextArrayList() {
		return textArrayList;
	}

	public void setTextArrayList(ArrayList<StringText> textArrayList) {
		this.textArrayList = textArrayList;
	}

	private static ArrayList<StringText> textArrayList;
	public static void screenSizeInit()
	{
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		_screenWidth = size.x;
		_screenHeight = size.y;
	}
	public static int getCurrentTextParagrph()
	{
		return currentTextParagraph;
	}
	public static void setCurrentTextParagrphMinusMinus()
	{
		if(currentTextParagraph >0)
		{
			currentTextParagraph--;
		}

	}
	public static void setCurrentTextParagrphPlusPlus()
	{
		if(currentTextParagraph < Consts.NUMBER_TEXT_PARAGRAPHS){
			currentTextParagraph++;
		}

	}
}
