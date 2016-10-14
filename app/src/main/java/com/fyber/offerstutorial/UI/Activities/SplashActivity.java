package com.fyber.offerstutorial.UI.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fyber.offerstutorial.R;

/**
 * Created by muhammadkorany on 10/14/16.
 */

public class SplashActivity extends Activity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            startActivity(new Intent(SplashActivity.this, FormActivity.class));
            finish();

            }
        }, 2000);
    }
}
