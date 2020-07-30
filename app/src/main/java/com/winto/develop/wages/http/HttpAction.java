package com.winto.develop.wages.http;


import android.text.TextUtils;

import com.winto.develop.wages.base.BaseResponse;
import com.winto.develop.wages.bean.LoginBean;
import com.winto.develop.wages.bean.WagesInfoBean;
import com.winto.develop.wages.bean.WagesListBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class HttpAction {

    public static HttpAction getInstance() {
        return HttpActionHolder.instance;
    }

    private static class HttpActionHolder {
        private static HttpAction instance = new HttpAction();
    }

    private RequestBody getBody(String params) {
        return RequestBody.create(MediaType.parse("text/html; charset=utf-8"), params);
    }

    private <T> Flowable<T> applySchedulers(Flowable<T> responseFlowable) {
        return responseFlowable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Flowable<LoginBean> login(Map<String, String> params) {
        return applySchedulers(HttpClient.getHttpService().login(generateRequestBody(params)));
    }

    public Flowable<WagesListBean> getWagesList(Map<String, Object> params) {
        return applySchedulers(HttpClient.getHttpService().getWagesList(params));
    }

    public Flowable<WagesInfoBean> getWagesInfo(Map<String, Object> params) {
        return applySchedulers(HttpClient.getHttpService().getWagesInfo(params));
    }

    /**
     * 转换为 form-data
     */
    private static Map<String, RequestBody> generateRequestBody(Map<String, String> requestDataMap) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : requestDataMap.keySet()) {
            MediaType type = MediaType.parse("multipart/form-data");
            RequestBody requestBody = RequestBody.create(type, TextUtils.isEmpty(requestDataMap.get(key)) ? "" : Objects.requireNonNull(requestDataMap.get(key)));
            requestBodyMap.put(key, requestBody);
        }
        return requestBodyMap;
    }
}
