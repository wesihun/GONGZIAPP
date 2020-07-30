package com.winto.develop.wages.activity;

import android.os.Handler;
import android.text.TextUtils;

import com.winto.develop.wages.MainApplication;
import com.winto.develop.wages.R;
import com.winto.develop.wages.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void initView() {
        new Handler().postDelayed(this::gotoActivity, 2000);
    }

    @Override
    protected void initClick() {

    }

    @Override
    protected void initData() {

    }

    private void gotoActivity() {
        String token = MainApplication.getContext().getToken();
        if (TextUtils.isEmpty(token)) {
            toClass(context, LoginActivity.class);
        } else {
            toClass(context, WagesListActivity.class);
        }
        finish();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }
}