package com.example.davids.minitabletapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.davids.minitabletapp.R;


public class DimFragment extends BaseFragment implements OnClickListener {

	private Button _backBtn;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.dim_fragment, container, false);
		initViews(view);
		initListeners();
		initData();

		return view;
		
	}
	
	@Override
	protected void initViews(View view) {
		_backBtn = (Button) view.findViewById(R.id.back);
	}

	@Override
	protected void initListeners() {
		_backBtn.setOnClickListener(this);
	}

	@Override
	protected void initHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initData() {
		getBaseActivity().changeScreenBrightness(0);
	}

	@Override
	public void showUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideUI() {
		
	}

	@Override
	public void setWebPageByResponse(int testId, String jsonResponse) {
		getBaseActivity().replaceFragment(NearVisionFragment.class, null);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			getBaseActivity().replaceFragment(NearVisionFragment.class, null);
			break;

		default:
			break;
		}
	}
	
}
