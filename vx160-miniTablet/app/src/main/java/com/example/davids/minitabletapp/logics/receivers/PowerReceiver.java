package com.example.davids.minitabletapp.logics.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.davids.minitabletapp.activities.MainActivity;

public class PowerReceiver extends BroadcastReceiver
{
	public static final String DIM_APP_KEY = "DIM_APP_KEY";
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
//		Log.d("anton","PowerReceiver onReceive action = "+intent.getAction());
//		Toast.makeText(context, "onReceive="+intent.getAction(), Toast.LENGTH_LONG).show();
		if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
		{
			if(MainActivity._isRunning)
			{
				Intent i = new Intent(context,MainActivity.class);
				i.putExtra(DIM_APP_KEY, true);
				i.addFlags(
					      Intent.FLAG_ACTIVITY_NEW_TASK
					    | Intent.FLAG_ACTIVITY_CLEAR_TOP
					    | Intent.FLAG_ACTIVITY_SINGLE_TOP);
				context.startActivity(i);
			}	
		}
		else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
		{
			Intent i = new Intent(context, MainActivity.class);
			i.putExtra(DIM_APP_KEY, false);
			i.addFlags(
				      Intent.FLAG_ACTIVITY_NEW_TASK
				    | Intent.FLAG_ACTIVITY_CLEAR_TOP
				    | Intent.FLAG_ACTIVITY_SINGLE_TOP);
			context.startActivity(i);
		}
	}
}
