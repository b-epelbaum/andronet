package com.example.davids.minitabletapp.activities;

import android.app.Activity;
import android.content.Intent;

public class MagicAppRestart extends Activity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
    }

    protected void onResume() {
        super.onResume();
        startActivityForResult(new Intent(this, MainActivity.class), 0);
    }
}
