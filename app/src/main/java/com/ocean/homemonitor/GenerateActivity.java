package com.ocean.homemonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GenerateActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        findViewById(R.id.btn_create).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    public static void launch(Activity from, boolean closeOther) {
        if (closeOther) {
            App.getInstance().finishAllActivities(MainActivity.class);
        }
        Intent intent = new Intent(from, MainActivity.class);
        from.startActivity(intent);
    }

    public static void launch(Activity from) {
        Intent intent = new Intent(from, GenerateActivity.class);
        from.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create:

                break;
            case R.id.btn_login:

                break;
        }
    }
}
