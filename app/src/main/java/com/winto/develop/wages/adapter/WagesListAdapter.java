package com.winto.develop.wages.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.winto.develop.wages.R;
import com.winto.develop.wages.bean.WagesListBean;

import java.util.List;

public class WagesListAdapter extends BaseAdapter {
    private Context context;
    private List<WagesListBean.DataBean> wagesList;

    public WagesListAdapter(Context context, List<WagesListBean.DataBean> wagesList) {
        this.context = context;
        this.wagesList = wagesList;
    }

    //第一要准确计算数量
    @Override
    public int getCount() {
        return wagesList.size();
    }

    @Override
    public WagesListBean.DataBean getItem(int position) {
        return wagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_wages_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        WagesListBean.DataBean wages = getItem(position);
        holder.tv_wages_title.setText(String.format("%s月份工资明细", wages.getYearmonth()));
        holder.tv_gs.setText(String.valueOf(wages.getGskk()));
        holder.tv_sb.setText(String.valueOf(wages.getSbje()));
        holder.tv_yf_wages.setText(String.valueOf(wages.getYfgz()));
        holder.tv_sf_wages.setText(String.valueOf(wages.getJle()));
        return convertView;
    }

    static class ViewHolder {
        public View rootView;
        public TextView tv_wages_title;
        public TextView tv_gs;
        public TextView tv_sb;
        public TextView tv_yf_wages;
        public TextView tv_sf_wages;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_wages_title = (TextView) rootView.findViewById(R.id.tv_wages_title);
            this.tv_gs = (TextView) rootView.findViewById(R.id.tv_gs);
            this.tv_sb = (TextView) rootView.findViewById(R.id.tv_sb);
            this.tv_yf_wages = (TextView) rootView.findViewById(R.id.tv_yf_wages);
            this.tv_sf_wages = (TextView) rootView.findViewById(R.id.tv_sf_wages);
        }

    }
}
