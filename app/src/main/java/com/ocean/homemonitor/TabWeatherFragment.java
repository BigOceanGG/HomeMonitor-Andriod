package com.ocean.homemonitor;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocean.homemonitor.databinding.FragmentTabWeatherBinding;

public class TabWeatherFragment extends BaseFragment {
    public static final int TYPE_SUMMER = 1;
    public static final int TYPE_WINNER = 2;

    private FragmentTabWeatherBinding mBinding;

    public static TabWeatherFragment newInstance(int type) {
        TabWeatherFragment fragment = new TabWeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_weather, null, false);
        return mBinding.getRoot();
    }
}
