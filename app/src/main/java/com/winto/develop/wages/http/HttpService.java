package com.winto.develop.wages.http;

import com.winto.develop.wages.base.BaseResponse;
import com.winto.develop.wages.bean.LoginBean;
import com.winto.develop.wages.bean.WagesInfoBean;
import com.winto.develop.wages.bean.WagesListBean;
import com.winto.develop.wages.constant.ConstantData;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface HttpService {
    @Streaming
    @GET
    Flowable<ResponseBody> downloadFile(@Url String fileUrl);

    @Multipart
    @POST("File/UploadSampleImage")
    Flowable<ResponseBody> uploadFiles(@Part MultipartBody.Part file);

    @Multipart
    @POST()
    Flowable<ResponseBody> uploadFiles(@Url String url, @Part MultipartBody.Part file);

    @Multipart
    @POST()
    Flowable<ResponseBody> UploadCompleteImage(@Url String url, @Part MultipartBody.Part file);

    @Multipart
    @POST("File/UploadSampleImage")
    Flowable<ResponseBody> uploadFiles(@Part List<MultipartBody.Part> parts);

    @Multipart
    @POST(ConstantData.HOST + "Mobile/UserLogin")
    Flowable<LoginBean> login(@PartMap Map<String, RequestBody> params);

    @GET(ConstantData.HOST + "Mobile/WagePageData")
    Flowable<WagesListBean> getWagesList(@QueryMap Map<String, Object> params);

    @GET(ConstantData.HOST + "Mobile/WageInfo")
    Flowable<WagesInfoBean> getWagesInfo(@QueryMap Map<String, Object> params);
}