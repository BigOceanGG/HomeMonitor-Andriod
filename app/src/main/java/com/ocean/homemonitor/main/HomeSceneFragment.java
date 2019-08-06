package com.ocean.homemonitor.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocean.homemonitor.R;
import com.ocean.homemonitor.databinding.FragmentHomeSceneBinding;
import com.ocean.homemonitor.widget.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeSceneFragment extends BaseFragment {
    public static HomeSceneFragment newInstance() {
        return new HomeSceneFragment();
    }

    private FragmentHomeSceneBinding mBinding;
    private List<String> mTabs = new ArrayList<>();
    private List<TabWeatherFragment> mFragments = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_scene, null, false);
        initView();
        return mBinding.getRoot();
    }

    private void initView() {
        TabWeatherFragment summerFragment = TabWeatherFragment.newInstance(TabWeatherFragment.TYPE_SUMMER);
        TabWeatherFragment winnerFragment = TabWeatherFragment.newInstance(TabWeatherFragment.TYPE_WINNER);
        mFragments.add(summerFragment);
        mFragments.add(winnerFragment);
        mTabs.add(getString(R.string.tab_summer));
        mTabs.add(getString(R.string.tab_winner));
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTabs.get(position);
            }
        };
        mBinding.vpWeather.setAdapter(adapter);
        for (int i = 0, len = mTabs.size(); i < len; i++) {
            mBinding.tlWeather.addTab(mBinding.tlWeather.newTab());
            mBinding.tlWeather.addTab(mBinding.tlWeather.newTab());
        }
        mBinding.tlWeather.setupWithViewPager(mBinding.vpWeather);
        for (int i = 0, len = mTabs.size(); i < len; i++) {
            mBinding.tlWeather.getTabAt(i).setText(mTabs.get(i));
        }
        mBinding.tlWeather.setColorChangeable(true);
        mBinding.tlWeather.setColor(ContextCompat.getColor(mActivity, R.color.orange),
                ContextCompat.getColor(mActivity, R.color.blue));
    }
}
