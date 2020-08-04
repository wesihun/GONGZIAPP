package com.winto.develop.wages.base;


import android.content.Intent;
import android.util.Log;

import com.winto.develop.wages.MainApplication;
import com.winto.develop.wages.activity.LoginActivity;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements FlowableSubscriber<T> {

    @Override
    public void onNext(T t) {
        try {
            onSuccess(t);
        } catch (Exception e) {
            onError("网络请求失败");
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable t) {
        try {
            if (t instanceof HttpException) {
                HttpException httpException = (HttpException) t;
                if (httpException.code() == 401) {
                    MainApplication.getContext().setToken("");
                    Intent intent = new Intent();
                    intent.setClass(MainApplication.getContext(), LoginActivity.class);
                    //关键的一句，将新的activity置为栈顶
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    MainApplication.getContext().startActivity(intent);
                    onError("登录状态已失效，请重新登录");
                } else {
                    onError("网络请求失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            onError("网络请求失败");
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Integer.MAX_VALUE);
    }

    public abstract void onSuccess(T bean);

    public abstract void onError(String message);
}
