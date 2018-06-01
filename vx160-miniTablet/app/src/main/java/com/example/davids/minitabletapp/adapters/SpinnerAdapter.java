package com.example.davids.minitabletapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.davids.minitabletapp.R;

import java.util.Arrays;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<String>
{

	private Context _con;
	private List<String> _data;


	public SpinnerAdapter(Context con, List<String> data)
	{
		super(con, R.layout.spinner_item);
		_con = con;
		_data = data;
	}

	public SpinnerAdapter(Context con, int layoutRes, String[] data)
	{
		super(con, layoutRes);
		_con = con;
		_data = Arrays.asList(data);
	}

	@Override
	public int getCount()
	{
		return _data.size();
	}

	@Override
	public String getItem(int position)
	{
		return _data.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{

		ViewHolder holder;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = LayoutInflater.from(_con).inflate(R.layout.spinner_item, parent, false);
			holder._text = (TextView) convertView.findViewById(R.id.text1);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder._text.setTextColor(Color.parseColor("#000000"));
		holder._text.setText(getItem(position));


		return convertView;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = LayoutInflater.from(_con).inflate(R.layout.spinner_item, parent, false);
			holder._text = (TextView) convertView.findViewById(R.id.text1);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder._text.setPadding(10, 10,10,10);
		holder._text.setTextColor(Color.parseColor("#000000"));
		holder._text.setText(getItem(position));
		return convertView;
	}

	public void setData(List<String> data)
	{
		_data = data;
		notifyDataSetChanged();
	}
	
	private static class ViewHolder
	{
		public TextView _text;
	}
}
