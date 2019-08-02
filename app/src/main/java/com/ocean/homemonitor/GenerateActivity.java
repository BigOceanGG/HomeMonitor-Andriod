package com.ocean.homemonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GenerateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
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
//        openAlpha(from);
    }
}
