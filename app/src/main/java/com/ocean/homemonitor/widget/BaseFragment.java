package com.ocean.homemonitor.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.ocean.homemonitor.bus.AppBus;

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        AppBus.register(this);
    }

}
