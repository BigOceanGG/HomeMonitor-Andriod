package com.ocean.homemonitor;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ocean.homemonitor.databinding.WetherItemBinding;

import java.util.List;

public class WeatherAdapter extends BaseAdapter<Account> {
    private int mType = TabWeatherFragment.TYPE_SUMMER;

    public WeatherAdapter(List<Account> data, Context context) {
        super(data, context);
    }
    @Override
    public int setLayId(ViewGroup parent, int viewType) {
        return R.layout.wether_item;
    }

    @Override
    public void setViews(ViewDataBinding viewDataBinding, int position) {
        WetherItemBinding binding = (WetherItemBinding) viewDataBinding;
        if (position == 0) {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) binding.getRoot().getLayoutParams();
            params.topMargin = DisplayUtil.dp2px(mContext, 16f);
            binding.getRoot().setLayoutParams(params);
        } else {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) binding.getRoot().getLayoutParams();
            params.topMargin = 0;
            binding.getRoot().setLayoutParams(params);
        }
        Account item = mData.get(position);
        String index;
        if (position + 1 < 10) {
            index = "0" + String.valueOf(position + 1);
        } else {
            index = String.valueOf(position + 1);
        }
        if (mType == TabWeatherFragment.TYPE_SUMMER) {
            binding.flAdd.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_gradient_summer));
        } else {
            binding.flAdd.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_gradient_winner));
        }
    }

    public void setType(int type) {
        mType = type;
    }
}
