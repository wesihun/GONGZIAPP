package com.winto.develop.wages.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.winto.develop.wages.MainApplication;
import com.winto.develop.wages.R;
import com.winto.develop.wages.base.BaseActivity;
import com.winto.develop.wages.base.BaseObserver;
import com.winto.develop.wages.bean.LoginBean;
import com.winto.develop.wages.http.HttpAction;
import com.winto.develop.wages.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private EditText et_search;
    private EditText et_password;
    private Button btn_search;
    private TextView tv_initialize_password;

    @Override
    protected void initView() {
        et_search = findViewById(R.id.et_search);
        et_password = findViewById(R.id.et_password);
        btn_search = findViewById(R.id.btn_search);
        tv_initialize_password = findViewById(R.id.tv_initialize_password);
    }

    @Override
    protected void initClick() {
        tv_initialize_password.setOnClickListener(view -> {
            toClass(context, SavePasswordActivity.class);
        });

        btn_search.setOnClickListener(view -> {
            String name = et_search.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                ToastUtil.show(context, "请输入姓名");
                return;
            }
            String password = et_password.getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                ToastUtil.show(context, "请输入密码");
                return;
            }
            login(name, password);
        });
    }

    @Override
    protected void initData() {

    }

    private void login(String userName, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("UserName", userName);
        params.put("PassWord", password);
        params.put("SfzCode", "");
        HttpAction.getInstance().login(params).subscribe(new BaseObserver<LoginBean>() {
            @Override
            public void onSuccess(LoginBean bean) {
                if (bean.getCode() != 200) {
                    ToastUtil.show(context, "登陆失败");
                    return;
                }
                MainApplication.getContext().setToken(bean.getToken());
                Intent intent = new Intent();
                intent.setClass(context, WagesListActivity.class);
                //关键的一句，将新的activity置为栈顶
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }
}