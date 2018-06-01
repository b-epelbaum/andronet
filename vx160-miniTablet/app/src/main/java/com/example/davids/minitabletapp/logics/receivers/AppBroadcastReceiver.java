package com.example.davids.minitabletapp.logics.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

import com.example.davids.minitabletapp.activities.MainActivity;


public class AppBroadcastReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.d("anton", "AppBroadcastReceiver onReceive "+intent.getAction());
		if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
		{
			//checking if the application started when the tablet is still charging
		     Intent i = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		     int plugged = i.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		     boolean devicePlugged = (plugged == BatteryManager.BATTERY_PLUGGED_AC || plugged == BatteryManager.BATTERY_PLUGGED_USB);
		     if(!devicePlugged)
		     {
				Intent appIntent = new Intent(context, MainActivity.class);
				appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(appIntent);
		     }
		}
	}
}
