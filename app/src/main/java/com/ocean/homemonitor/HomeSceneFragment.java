package com.ocean.homemonitor;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocean.homemonitor.databinding.FragmentHomeSceneBinding;

public class HomeSceneFragment extends BaseFragment {
    public static HomeSceneFragment newInstance() {
        return new HomeSceneFragment();
    }

    private FragmentHomeSceneBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_scene, null, false);
        initView();
        return mBinding.getRoot();
    }

    private void initView() {

    }
}
