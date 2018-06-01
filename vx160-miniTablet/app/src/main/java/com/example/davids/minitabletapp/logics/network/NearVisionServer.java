package com.example.davids.minitabletapp.logics.network;

import android.util.Log;


import com.example.davids.minitabletapp.NearVisionApplication;
import com.example.davids.minitabletapp.logics.Consts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

public class NearVisionServer extends NanoHTTPD
{

	private ServerInterface listener;



	public NearVisionServer()
	{
		super(Consts.SERVER_PORT);

	}

	public void initDataStructures()
	{


	}

	@Override
	public Response serve(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files)
	{

		Set<String> keySet = parms.keySet();
		for (String currentParamKey : keySet)
		{
			Log.d("anton", currentParamKey + "," + parms.get(currentParamKey));
		}

		String response = "";
		if (parms.containsKey("cmd"))
		{
			String cmdCommand = parms.get("cmd");
			Consts.L40Cmd selectedTest = getSelectedTest(cmdCommand);
			//    		int selectedTestId = selectedTest.mTestId;
			response = generateResponse(selectedTest);
			Log.d("anton", "response=" + response);
			if(listener !=null)
			{
				listener.setWebPageByResponse(selectedTest.mTestId, response);
			}
		}
		return newFixedLengthResponse(response);
	}

	public String generateResponse(Consts.L40Cmd selectedTest)
	{
		long msec = getResponseTimeInMillis();

		String res = null;
		Gson gson = new GsonBuilder().registerTypeAdapter(ServerResponse.class, new ResponseJsonSerializer()).setPrettyPrinting().create();
		ServerResponse sRes = new ServerResponse();

		sRes.setTest(selectedTest.mTestId);
		sRes.setCmd(selectedTest.mCmd);
		sRes.setPtime(msec);

		String firstRow = "";
		String secondRow = "";
		String ac1 = "";
		String ac2 = "";
		switch (selectedTest.mTestId)
		{
			case 500:
			case 501:
				break;
			case 502:
				//_currentTextParagraph = Consts.NUMBER_TEXT_PARAGRAPHS - 1;

				firstRow = NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagraph()).getText();
				//secondRow = _langParagraphs.get(_currentTextParagraph);

				ac1 =NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagraph()).getTextHeaderWithoutSpaces();
				//ac2 = _vaParagraphs[_currentTextParagraph];

				sRes.setTextOne(firstRow);

				sRes.setAc1(ac1);
 				break;
			case 503:
				NearVisionApplication.setCurrentTextParagrphPlusPlus();
				//_currentTextParagraph++;
//				if(_currentTextParagraph>=Consts.NUMBER_TEXT_PARAGRAPHS)
//				{
//					_currentTextParagraph = Consts.NUMBER_TEXT_PARAGRAPHS-1;
//				}

				firstRow =NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagraph()).getText();
				//secondRow = _langParagraphs.get(_currentTextParagraph);

				ac1 =NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagraph()).getTextHeaderWithoutSpaces();
				//ac2 = _vaParagraphs[_currentTextParagraph];

				sRes.setTextOne(firstRow);

				sRes.setAc1(ac1);
 				break;
			case 504:
				//_currentTextParagraph--;
				NearVisionApplication.setCurrentTextParagrphMinusMinus();
				firstRow =NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagraph()).getText();
				//	secondRow = _langParagraphs.get(_currentTextParagraph);

				ac1 = NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagraph()).getTextHeaderWithoutSpaces();
				//	ac2 = _vaParagraphs[_currentTextParagraph];

				sRes.setTextOne(firstRow);
				sRes.setAc1(ac1);





				break;
		}
		res = gson.toJson(sRes);
		return res;
	}


	//	private ServerResponse getResponseFromIshiarhaAction(String actionKey, String testKey) {
	//		
	//		ServerResponse res = _tests.get(testKey);
	//		
	//		if(actionKey.equals("UP"))
	//		{
	//			_testPlancheIndex = 0;
	//			_testCategoryIndex = (++_testCategoryIndex) % _testCategoryLimit;
	//			
	//		}
	//		else if(actionKey.equals("DOWN"))
	//		{
	//			_testPlancheIndex = 0;
	//			_testCategoryIndex = (--_testCategoryIndex) % _testCategoryLimit;
	//		}
	//		else if(actionKey.equals("LEFT"))
	//		{
	//			_testPlancheIndex = (--_testPlancheIndex)  % _testPlancheLimit;
	//		}
	//		else if(actionKey.equals("RIGHT"))
	//		{
	//			_testPlancheIndex = (++_testPlancheIndex)  % _testPlancheLimit;
	//		}
	//		
	//		if(_testCategoryIndex < 0)
	//		{
	//			_testCategoryIndex+=_testCategoryLimit; 
	//		}
	//		
	//		if(_testPlancheIndex<0)
	//		{
	//			_testPlancheIndex+=_testPlancheLimit;
	//		}
	//		
	//		int selectedPlanche = _ishTests.get(_testCategoryIndex).get(_testPlancheIndex);
	//		
	//		res.setCategory(_testCategoryIndex);
	//		res.setPlanche(selectedPlanche);
	//		
	//		return res;
	//		
	//	}

	private long getResponseTimeInMillis()
	{
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
	}

	public void setResponseListener(ServerInterface listener)
	{
		this.listener = listener;
	}

	private Consts.L40Cmd getSelectedTest(String cmdCommand)
	{
		Consts.L40Cmd selectedTest = null;
		for (Consts.L40Cmd test : Consts.L40Cmd.values())
		{
			if (test.mCmd.equals(cmdCommand))
			{
				selectedTest = test;
				break;
			}
		}
		return selectedTest;
	}

	public interface ServerInterface
	{
		public void setWebPageByResponse(int testId, String jsonResponse);
	}

}