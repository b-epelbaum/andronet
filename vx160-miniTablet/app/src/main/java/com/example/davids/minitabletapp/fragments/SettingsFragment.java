package com.example.davids.minitabletapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.davids.minitabletapp.Entities.Language;
import com.example.davids.minitabletapp.Helpers.PrefHelper;
import com.example.davids.minitabletapp.NearVisionApplication;
import com.example.davids.minitabletapp.R;
import com.example.davids.minitabletapp.adapters.SpinnerAdapter;
import com.example.davids.minitabletapp.logics.Consts;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends BaseFragment implements OnItemSelectedListener, OnClickListener
{

	private List<String> _supportedLanguages;
	private String _selectedLanguagePrefix;
	private List<Language> _supportedLanguagesList;
	
	private Spinner _functionalitiesSpinner;
	private Button _changeTimeAndDate;
	private TextView _dateTimeText;

	private Spinner _langSpinner;
	private Button _backBtn;
	private TextView _nvTabletVersion;

	private Spinner _fixationTestSpinner;
	private Spinner vxLanSpinner;
	private boolean restartApp;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.settings_fragment, container, false);

		initViews(view);
		initListeners();
		initData();

		return view;
	}

	@Override
	protected void initViews(View view)
	{
		_backBtn = (Button) view.findViewById(R.id.back);
		_changeTimeAndDate = (Button) view.findViewById(R.id.change_timestamp);
		_functionalitiesSpinner = (Spinner) view.findViewById(R.id.nv_tab_function_spinner);
		_dateTimeText = (TextView) view.findViewById(R.id.current_timestamp);
		_langSpinner = (Spinner) view.findViewById(R.id.language_spinner);
		_nvTabletVersion = (TextView) view.findViewById(R.id.nv_tablet_version);

		_fixationTestSpinner = (Spinner) view.findViewById(R.id.fixation_test_spinner);
		vxLanSpinner = (Spinner) view.findViewById(R.id.vxLanSpinner);

	}

	@Override
	protected void initListeners()
	{
		_functionalitiesSpinner.setOnItemSelectedListener(this);
		_changeTimeAndDate.setOnClickListener(this);
		_langSpinner.setOnItemSelectedListener(this);
		_fixationTestSpinner.setOnItemSelectedListener(this);
		_backBtn.setOnClickListener(this);

	}

	@Override
	protected void initHandler()
	{
		// TODO Auto-generated method stub

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
		String versionName = getBaseActivity().getVersionName();
		_nvTabletVersion.setText(versionName);
		
		
		_supportedLanguagesList = new ArrayList<Language>();
		_supportedLanguages=new ArrayList<String>();
		_supportedLanguagesList.add(new  Language("en", "English" ,"0001"));
		_supportedLanguagesList.add(new  Language("fr", "Français","0002"));
		_supportedLanguagesList.add(new  Language("es", "Español" ,"0003"));
		_supportedLanguagesList.add(new  Language("it", "Italiano","0004"));
		_supportedLanguagesList.add(new  Language("de", "Deutsch"  ,"0005"));
		_supportedLanguagesList.add(new  Language("sv", "Svenska"  ,"0006"));
		_supportedLanguagesList.add(new  Language("de,LU", "Deutsch #2"  ,"0007"));
		_supportedLanguagesList.add(new  Language("en,GB", "English #2"  ,"0008"));
		_selectedLanguagePrefix = PrefHelper.getLanguage();
		
		String selectedLanguage = null;
		for (Language lang : _supportedLanguagesList)
		{
			if (lang.getLangPrefix().equals(_selectedLanguagePrefix))
			{
				selectedLanguage = lang.getLangName();
			}
			_supportedLanguages.add(lang.getLangName());
		}

		
		SpinnerAdapter spinnerArrayAdapter = new SpinnerAdapter(getActivity(), _supportedLanguages); //selected item will look like a spinner set from XML
		_langSpinner.setAdapter(spinnerArrayAdapter);
		_langSpinner.setSelection(_supportedLanguages.indexOf(selectedLanguage));

		ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
				R.array.vxlan_list, R.layout.item_spinner_map);

		adapter.setDropDownViewResource(R.layout.item_spinner_dropdown_map);
		restartApp=false;
		vxLanSpinner.setAdapter(adapter);
		vxLanSpinner.setSelection(getVXLanPosition(PrefHelper.getVxLan()   ));
		vxLanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String[] testArray = getResources().getStringArray(R.array.vxlan_list);

				PrefHelper.setVxLan(testArray[position]);


				if (restartApp) {
                     getBaseActivity().restartApp();
				}
				restartApp=true;
				 Log.w("VXLAN",PrefHelper.getVxLan());

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

  @Override
  public  void onStop(){
	  super.onStop();

}
	@Override
	public void onResume()
	{
		super.onResume();
		getBaseActivity().changeScreenBrightness(100);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{
		switch (parent.getId())
		{
		//			case R.id.nv_tab_function_spinner:
		//				String selectedFucntionality = (String) _functionalitiesSpinner.getAdapter().getItem(position);
		//				 Logics.getInstance().putString(SharedPreferencesManager.SELECTED_NV_FUNCTION_KEY, selectedFucntionality);
		//				break;
					case R.id.language_spinner:
						PrefHelper.setLanguage(_supportedLanguagesList.get(position).getLangPrefix());
						 NearVisionApplication._changedLanguagePrefix = _supportedLanguagesList.get(position).getLangPrefix();

						 break;
		//			case R.id.fixation_test_spinner:
		//				 Logics.getInstance().putInt(SharedPreferencesManager.SELECTED_FIXATION_INDEX_KEY, position);
		//				break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.change_timestamp:
				startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
				break;
			case R.id.back:
				Bundle b = new Bundle();
				b.putString(Consts.SELECTED_MANUAL_LANGUAGE_KEY, _selectedLanguagePrefix);
				getBaseActivity().replaceFragment(NearVisionFragment.class, b);
				NearVisionApplication.initData();
				break;
		}
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
}
