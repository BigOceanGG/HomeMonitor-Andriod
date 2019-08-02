package com.ocean.homemonitor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.ocean.homemonitor.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity{

    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        initView();
    }

    private void initView() {
        mBinding.ivEnter.setEnabled(false);
        mBinding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    mBinding.ivEnter.setImageResource(R.drawable.ico_enter_activited);
                    mBinding.ivEnter.setEnabled(true);
                } else {
                    mBinding.ivEnter.setImageResource(R.drawable.ico_enter_normal);
                    mBinding.ivEnter.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBinding.ivEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = mBinding.etPassword.getText().toString();
                if(password.equals("123")){
                    finish();
                    return;
                }
                mBinding.etPassword.setText("");
                showToast(R.string.password_wrong);
            }
        });
    }

    protected void showToast(@StringRes int res) {
        ToastUtil.showToast(res);
    }

    public static void launch(Activity from) {
        Intent intent = new Intent(from, LoginActivity.class);
        from.startActivity(intent);
    }

    public static void launch(Context from) {
        Intent intent = new Intent(from, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        from.startActivity(intent);
    }
}
