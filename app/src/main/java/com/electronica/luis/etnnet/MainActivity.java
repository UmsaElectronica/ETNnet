package com.electronica.luis.etnnet;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;

import com.electronica.luis.etnnet.R;

public class MainActivity extends Activity {
    private static int SPLAH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i);
                finish();
            }

        },SPLAH_TIME_OUT);
    }
}
