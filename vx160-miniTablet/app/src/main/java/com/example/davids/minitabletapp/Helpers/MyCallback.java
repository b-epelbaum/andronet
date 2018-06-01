package com.example.davids.minitabletapp.Helpers;

/**
 * Created by david-qeezz on 15/10/2015.
 */
public abstract class MyCallback {
    abstract public void onSuccess(String response);

    public void onError(String error) {

    }
    public void onMessage(String message) {

    }
}
