package com.kimchohee.fragmenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new splashhandler(), 1500);
    }

    private class splashhandler implements Runnable{

        @Override
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
           //super.onBackPressed();
    }
}
