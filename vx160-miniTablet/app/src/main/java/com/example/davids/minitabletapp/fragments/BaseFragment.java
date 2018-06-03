package com.example.davids.minitabletapp.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.davids.minitabletapp.activities.BaseActivity;
import com.example.davids.minitabletapp.activities.MainActivity;
import com.example.davids.minitabletapp.logics.network.NearVisionServer;

import java.util.ArrayList;

public abstract class BaseFragment extends Fragment implements NearVisionServer.ServerInterface {
    protected Handler _handler;

    protected abstract void initViews(View view);

    protected abstract void initListeners();

    protected abstract void initHandler();

    protected abstract void initData();

    public abstract void showUI();

    public abstract void hideUI();

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    @Override
    public void setWebPageByResponse(int testId, String jsonResponse) {
        //override in nearvisionFragment tablet and dimFragment
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!((MainActivity) getBaseActivity()).isSoftKeysVisible()) {
            hideUI();
        }
    }

    //called from replace fragment in baseActivity
    public void setNewArguments(Bundle b) {
        //copy new bundle to existing fragment
        //			Log.d("anton", "****************************************************");
        for (String key : b.keySet()) {
            Object value = b.get(key);
            if (value instanceof String) {
                String strValue = (String) value;
                getArguments().putString(key, strValue);
            }
            if (value instanceof Integer) {
                int intValue = (Integer) value;
                getArguments().putInt(key, intValue);
            }

            if (value instanceof Boolean) {
                boolean boolValue = (Boolean) value;
                getArguments().putBoolean(key, boolValue);
            }

            if (value instanceof ArrayList<?>) {
                ArrayList<? extends Parcelable> listValue = (ArrayList<? extends Parcelable>) value;
                getArguments().putParcelableArrayList(key, listValue);
            }

            if (value instanceof Long) {
                long longValue = (Long) value;
                getArguments().putLong(key, longValue);
            }

            if (value == null) {
                getArguments().remove(key);
            }

        }
    }

}
