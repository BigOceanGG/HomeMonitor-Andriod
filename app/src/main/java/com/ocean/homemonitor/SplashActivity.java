package com.ocean.homemonitor;

import android.os.Bundle;
import com.ocean.homemonitor.widget.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        launch();
    }

    private void launch() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                GenerateActivity.launch(mActivity);
                finish();
            }
        }, 2000);

    }
}
