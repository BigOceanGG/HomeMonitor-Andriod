package com.ocean.homemonitor;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocean.homemonitor.databinding.FragmentTabWeatherBinding;
import com.ocean.homemonitor.databinding.WetherItemBinding;

import java.util.ArrayList;
import java.util.List;

public class TabWeatherFragment extends BaseFragment implements View.OnClickListener{
    public static final int TYPE_SUMMER = 1;
    public static final int TYPE_WINNER = 2;

    private FragmentTabWeatherBinding mBinding;
    private WetherItemBinding mItemBinding;
    private List<Account> mData = new ArrayList<>();
    private WeatherAdapter mInnerAdapter;
    private HeaderAndFooterWrapper mAdapter;
    private int mType = TYPE_SUMMER;

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
        mInnerAdapter = new WeatherAdapter(mData, mActivity);
        mAdapter = new HeaderAndFooterWrapper(mInnerAdapter);
        mType = getArguments().getInt("type");
        mInnerAdapter.setType(mType);
        mBinding.rvWeather.setLayoutManager(new LinearLayoutManager(mActivity));
        mBinding.rvWeather.setAdapter(mAdapter);
        initData();
        initListener();
        return mBinding.getRoot();
    }

    private void initData() {
        if (mType == TYPE_SUMMER) {
            for (int i = 0, len = 2; i < len; i++) {
                Account ac = new Account();
                ac.setNonce(i);
                mData.add(ac);
            }
            mAdapter.notifyDataSetChanged();
        } else {
            for (int i = 0, len = 3; i < len; i++) {
                Account ac = new Account();
                ac.setNonce(i);
                mData.add(ac);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initListener() {
        mInnerAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                if (position < mData.size()) {
                    for (int i = 0, len = 3; i < len; i++) {
                        Account ac = new Account();
                        ac.setNonce(i);
                        mData.add(ac);
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_add:
                break;
        }
    }
}
