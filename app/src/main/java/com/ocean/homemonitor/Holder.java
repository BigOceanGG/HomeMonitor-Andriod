package com.ocean.homemonitor;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Holder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mViewDataBinding;

    public Holder(T viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.mViewDataBinding = viewDataBinding;
    }

    public Holder(View itemView) {
        super(itemView);
    }

    public T getBinding() {
        return mViewDataBinding;
    }

}
