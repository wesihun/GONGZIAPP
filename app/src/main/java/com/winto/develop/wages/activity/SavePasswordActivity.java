package com.winto.develop.wages.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.winto.develop.wages.MainApplication;
import com.winto.develop.wages.R;
import com.winto.develop.wages.base.BaseActivity;
import com.winto.develop.wages.base.BaseObserver;
import com.winto.develop.wages.base.BaseResponse;
import com.winto.develop.wages.bean.LoginBean;
import com.winto.develop.wages.http.HttpAction;
import com.winto.develop.wages.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class SavePasswordActivity extends BaseActivity {

    private Button btn_save;
    private EditText et_user_name;
    private EditText et_password;
    private EditText et_password_confirm;
    private EditText et_id_card;

    @Override
    protected void initView() {
        et_user_name = findViewById(R.id.et_user_name);
        et_password = findViewById(R.id.et_password);
        et_password_confirm = findViewById(R.id.et_password_confirm);
        et_id_card = findViewById(R.id.et_id_card);
        btn_save = findViewById(R.id.btn_save);
    }

    @Override
    protected void initClick() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = et_user_name.getText().toString().trim();
                if (TextUtils.isEmpty(userName)) {
                    ToastUtil.show(context, "请输入用户名");
                    return;
                }
                String password = et_password.getText().toString().trim();
                if (TextUtils.isEmpty(password)) {
                    ToastUtil.show(context, "请输入密码");
                    return;
                }
                String passwordConfirm = et_password_confirm.getText().toString().trim();
                if (TextUtils.isEmpty(passwordConfirm)) {
                    ToastUtil.show(context, "请输入确认密码");
                    return;
                }
                String idCard = et_id_card.getText().toString().trim();
                if (TextUtils.isEmpty(idCard)) {
                    ToastUtil.show(context, "请输入身份证号后四位");
                    return;
                }
                register(userName, password, idCard);
            }
        });
    }

    private void register(String userName, String password, String idCard) {
        Map<String, String> params = new HashMap<>();
        params.put("UserName", userName);
        params.put("PassWord", password);
        params.put("SfzCode", idCard);
        HttpAction.getInstance().login(params).subscribe(new BaseObserver<LoginBean>() {
            @Override
            public void onSuccess(LoginBean bean) {
                if (bean.getCode() != 200) {
                    ToastUtil.show(context, "初始化密码失败");
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
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_save_password;
    }
}