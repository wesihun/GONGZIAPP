package com.winto.develop.wages.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.winto.develop.wages.MainApplication;
import com.winto.develop.wages.R;
import com.winto.develop.wages.adapter.WagesListAdapter;
import com.winto.develop.wages.base.BaseActivity;
import com.winto.develop.wages.base.BaseObserver;
import com.winto.develop.wages.bean.WagesListBean;
import com.winto.develop.wages.http.HttpAction;
import com.winto.develop.wages.util.StatusBarHelper;
import com.winto.develop.wages.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WagesListActivity extends BaseActivity {

    private WagesListAdapter adapter;
    private SmartRefreshLayout srl_refresh;
    private ImageView iv_back;
    private ListView lv_wages_list;
    private View layout_empty;
    private List<WagesListBean.DataBean> wagesList;
    private int page = 1;

    @Override
    protected void initView() {
        iv_back = findViewById(R.id.iv_back);
        srl_refresh = findViewById(R.id.srl_refresh);
        layout_empty = findViewById(R.id.layout_empty);
        RelativeLayout rl_title = findViewById(R.id.rl_title);
        lv_wages_list = findViewById(R.id.lv_wages_list);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rl_title.getLayoutParams();
        params.topMargin = StatusBarHelper.getStatusBarHeight();
        rl_title.setLayoutParams(params);
        srl_refresh.setEnableAutoLoadMore(false);
    }

    @Override
    protected void initAdapter() {
        wagesList = new ArrayList<>();
        adapter = new WagesListAdapter(context, wagesList);
        lv_wages_list.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        getWagesList();
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(view -> finish());

        lv_wages_list.setOnItemClickListener((adapterView, view, i, l) -> {
            Bundle bundle = new Bundle();
            bundle.putString("id", adapter.getItem(i).getId());
            toClass(context, WagesDetailActivity.class, bundle);
        });

        srl_refresh.setOnRefreshListener(refreshLayout -> {
            page = 1;
            getWagesList();
        });

        srl_refresh.setOnLoadMoreListener(refreshLayout -> {
            page++;
            getWagesList();
        });
    }

    private void getWagesList() {
        Map<String, Object> params = new HashMap<>();
        params.put("Page", page);
        params.put("Limit", 20);
        HttpAction.getInstance().getWagesList(params).subscribe(new BaseObserver<WagesListBean>() {
            @Override
            public void onSuccess(WagesListBean bean) {
                if (bean.getCode() == 400) {
                    MainApplication.getContext().setToken("");
                    Intent intent = new Intent();
                    intent.setClass(context, LoginActivity.class);
                    //关键的一句，将新的activity置为栈顶
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    return;
                }
                if (bean.getCode() != 200) {
                    srl_refresh.finishRefresh();
                    srl_refresh.finishLoadMore();
                    ToastUtil.show(context, "网络连接失败");
                    showEmptyView(true);
                    return;
                }
                if (page == 1) {
                    addHeader(bean.getData());
                    srl_refresh.finishRefresh();
                } else {
                    addFooter(bean.getData());
                    srl_refresh.finishLoadMore();
                }
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
                showEmptyView(true);
                srl_refresh.finishRefresh();
                srl_refresh.finishLoadMore();
            }
        });
    }

    private void addHeader(List<WagesListBean.DataBean> data) {
        wagesList.clear();
        wagesList.addAll(data);
        showEmptyView(wagesList.size() == 0);
        adapter.notifyDataSetChanged();
    }

    private void addFooter(List<WagesListBean.DataBean> data) {
        wagesList.addAll(data);
        showEmptyView(wagesList.size() == 0);
        adapter.notifyDataSetChanged();
    }

    private void showEmptyView(boolean isShow) {
        if (isShow) {
            lv_wages_list.setVisibility(View.GONE);
            layout_empty.setVisibility(View.VISIBLE);
        } else {
            lv_wages_list.setVisibility(View.VISIBLE);
            layout_empty.setVisibility(View.GONE);
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_wages_list;
    }
}