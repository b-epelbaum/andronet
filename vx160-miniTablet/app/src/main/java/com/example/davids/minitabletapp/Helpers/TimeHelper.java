package com.example.davids.minitabletapp.Helpers;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Anton on 2/2/2017.
 */

public class TimeHelper {
    private static int timeOutCount;
    private static int count;
    private static Timer T;
    public static MyCallback callback;

    public static   void intTimer(int timeOut, MyCallback callback) {
        timeOutCount =timeOut/1000;
         count = timeOut / 1000;
        TimeHelper.callback=callback;
        T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (count<=0){
                    backHandler.obtainMessage(1).sendToTarget();
                    cancel();
                }
                count--;
            }
        }, 1000, 1000);
    }
    public static Handler backHandler = new Handler() {
        public void handleMessage(Message msg) {
            callback.onSuccess("");
        }
    };

}
