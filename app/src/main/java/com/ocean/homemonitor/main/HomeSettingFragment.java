package com.ocean.homemonitor.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocean.homemonitor.GenerateActivity;
import com.ocean.homemonitor.R;
import com.ocean.homemonitor.databinding.FragmentHomeSettingBinding;
import com.ocean.homemonitor.widget.BaseFragment;

public class HomeSettingFragment extends BaseFragment implements View.OnClickListener {
    private FragmentHomeSettingBinding mBinding;

    public static HomeSettingFragment newInstance() {
        return new HomeSettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_setting, null, false);
        mBinding.setClick(this);
        initView();
        return mBinding.getRoot();
    }

    private void initView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                GenerateActivity.launch(mActivity);
                break;
            case R.id.title_test:
                GenerateActivity.launch(mActivity);
                break;
        }
    }
}
