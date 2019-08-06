package com.ocean.homemonitor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.ocean.homemonitor.databinding.ActivityLoginBinding;
import com.ocean.homemonitor.main.MainActivity;
import com.ocean.homemonitor.utils.KeyboardUtil;
import com.ocean.homemonitor.utils.ToastUtil;
import com.ocean.homemonitor.widget.AlertDialog;
import com.ocean.homemonitor.widget.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;
    private AsyncTask mLoadTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        initView();
    }

    @Override
    public void finish() {
        super.finish();
        closeAlpha(mActivity);
    }

    @Override
    protected void onDestroy() {
        if (mLoadTask != null && mLoadTask.getStatus() != AsyncTask.Status.FINISHED) {
            mLoadTask.cancel(true);
        }
        super.onDestroy();
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
                    //mLoadTask = new LoadTask().execute(password);
                    finish();
                    MainActivity.launch(mActivity, true);
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
        openAlpha(from);
    }

    public static void launch(Context from) {
        Intent intent = new Intent(from, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        from.startActivity(intent);
    }

    private class LoadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String password = params[0];
            try {
                //在调用sleep()方法的过程中，线程不会释放对象锁。
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showLoading();
        }

        @Override
        protected void onPostExecute(String str) {
            hideLoading();
            showPasswordErrorDialog();
        }
    }

    private void showKeyboard() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                KeyboardUtil.show(mActivity, mBinding.etPassword);
            }
        }, 50);
    }

    private void showPasswordErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity, R.style.BasicAlertDialog_Light);
        builder.setTitle(R.string.password_wrong)
                .setIcon(R.drawable.basic_ico_alert)
                .setPositiveButton(R.string.basic_alert_dialog_confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mBinding.etPassword.setText(null);
                        showKeyboard();
                    }
                })
                .setNegativeButton(R.string.basic_alert_dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .confirm();
    }
}
