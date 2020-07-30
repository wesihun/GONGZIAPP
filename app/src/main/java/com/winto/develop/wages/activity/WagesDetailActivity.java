package com.winto.develop.wages.activity;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.winto.develop.wages.R;
import com.winto.develop.wages.base.BaseActivity;
import com.winto.develop.wages.base.BaseObserver;
import com.winto.develop.wages.bean.LoginBean;
import com.winto.develop.wages.bean.WagesInfoBean;
import com.winto.develop.wages.http.HttpAction;
import com.winto.develop.wages.util.StatusBarHelper;
import com.winto.develop.wages.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class WagesDetailActivity extends BaseActivity {

    private RelativeLayout rl_title;
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_tips1;
    private TextView tv_wages;
    private TextView tv_tips2;
    private TextView tv_base_wages;
    private TextView tv_bonus;
    private TextView tv_zcrygljt;
    private TextView tv_gljt;
    private TextView tv_tsjt;
    private TextView tv_xljt;
    private TextView tv_zcjt;
    private TextView tv_dhfbz;
    private TextView tv_snwcf;
    private TextView tv_snjtf;
    private TextView tv_wybt;
    private TextView tv_bsjkk;
    private TextView tv_lsfy;
    private TextView tv_yfgz;
    private TextView tv_sbkk;
    private TextView tv_sbtsqk;
    private TextView tv_gskk;
    private TextView tv_jle;
    private TextView tv_user_name;
    private TextView tv_qz;
    private TextView tv_zqz;
    private TextView tv_jzgw;
    private TextView tv_zyxl;
    private TextView tv_gj;
    private String id;

    @Override
    protected void initView() {
        rl_title = findViewById(R.id.rl_title);
        iv_back = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        tv_tips1 = findViewById(R.id.tv_tips1);
        tv_wages = findViewById(R.id.tv_wages);
        tv_tips2 = findViewById(R.id.tv_tips2);
        tv_base_wages = findViewById(R.id.tv_base_wages);
        tv_bonus = findViewById(R.id.tv_bonus);
        tv_zcrygljt = findViewById(R.id.tv_zcrygljt);
        tv_gljt = findViewById(R.id.tv_gljt);
        tv_tsjt = findViewById(R.id.tv_tsjt);
        tv_xljt = findViewById(R.id.tv_xljt);
        tv_zcjt = findViewById(R.id.tv_zcjt);
        tv_dhfbz = findViewById(R.id.tv_dhfbz);
        tv_snwcf = findViewById(R.id.tv_snwcf);
        tv_snjtf = findViewById(R.id.tv_snjtf);
        tv_wybt = findViewById(R.id.tv_wybt);
        tv_bsjkk = findViewById(R.id.tv_bsjkk);
        tv_lsfy = findViewById(R.id.tv_lsfy);
        tv_yfgz = findViewById(R.id.tv_yfgz);
        tv_sbkk = findViewById(R.id.tv_sbkk);
        tv_sbtsqk = findViewById(R.id.tv_sbtsqk);
        tv_gskk = findViewById(R.id.tv_gskk);
        tv_jle = findViewById(R.id.tv_jle);
        tv_user_name = findViewById(R.id.tv_user_name);
        tv_qz = findViewById(R.id.tv_qz);
        tv_zqz = findViewById(R.id.tv_zqz);
        tv_jzgw = findViewById(R.id.tv_jzgw);
        tv_zyxl = findViewById(R.id.tv_zyxl);
        tv_gj = findViewById(R.id.tv_gj);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) rl_title.getLayoutParams();
        params.topMargin = StatusBarHelper.getStatusBarHeight();
        rl_title.setLayoutParams(params);
    }

    @Override
    protected void initIntentData() {
        id = getIntent().getStringExtra("id");
    }

    @Override
    protected void initClick() {
        iv_back.setOnClickListener(view -> finish());
    }

    @Override
    protected void initData() {
        getWagesList();
    }

    private void getWagesList() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        HttpAction.getInstance().getWagesInfo(params).subscribe(new BaseObserver<WagesInfoBean>() {
            @Override
            public void onSuccess(WagesInfoBean bean) {
                if (bean.getCode() != 200) {
                    ToastUtil.show(context, "网络连接失败");
                    return;
                }
                setPage(bean.getData());
            }

            @Override
            public void onError(String message) {
                ToastUtil.show(context, message);
            }
        });
    }

    private void setPage(WagesInfoBean.DataBean data) {
        /*  `USERNAME` varchar(255) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL COMMENT '姓名',
            `USERQZ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '族群',
            `DEPARTBM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
            `JOBSGW` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位',
            `GLZY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理/专业序列',
            `GJ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗级',
            `GWJBGZ` float(10, 2) NULL DEFAULT NULL COMMENT '岗位基本工资',
            `JZ` float(10, 2) NULL DEFAULT NULL COMMENT '奖金',
            `ZCGLRYJT` float(10, 2) NULL DEFAULT NULL COMMENT '中层管理人员津贴',
            `GLJT` float(10, 2) NULL DEFAULT NULL COMMENT '工龄津贴',
            `GJTSJT` float(10, 2) NULL DEFAULT NULL COMMENT '高技术津贴/特殊津贴',
            `XLJT` float(10, 2) NULL DEFAULT NULL COMMENT '学历津贴',
            `ZCJT` float(10, 2) NULL DEFAULT NULL COMMENT '职称津贴',
            `DHBJ` float(10, 2) NULL DEFAULT NULL COMMENT '电话费补助',
            `SNWCF` float(10, 2) NULL DEFAULT NULL COMMENT '市内午餐費',
            `SNJTF` float(10, 2) NULL DEFAULT NULL COMMENT '市内交通費',
            `WYBT` float(10, 2) NULL DEFAULT NULL COMMENT '外业补贴（含加班）',
            `BSJKK` float(10, 2) NULL DEFAULT NULL COMMENT '病事假扣款',
            `LSFY` float(10, 2) NULL DEFAULT NULL COMMENT '临时费用',
            `YFGZ` float(10, 2) NULL DEFAULT NULL COMMENT '应付工资',
            `SBJE` float(10, 2) NULL DEFAULT NULL COMMENT '社保扣款',
            `SBTSQK` float(10, 2) NULL DEFAULT NULL COMMENT '社保特殊情况',
            `GSKK` float(10, 2) NULL DEFAULT NULL COMMENT '个税扣款',
            `JLE` float(10, 2) NULL DEFAULT NULL COMMENT '净领额',
            `BATCHID` varchar(255) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL COMMENT '批次编号',
            `YEARMONTH` varchar(100) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL COMMENT '年月',
            `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',*/
        tv_title.setText(data.getYearmonth() + "月工资明细");
        tv_wages.setText(String.valueOf(data.getJle()));
        tv_base_wages.setText(String.valueOf(data.getGwjbgz()));
        tv_bonus.setText(String.valueOf(data.getJz()));
        tv_zcrygljt.setText(String.valueOf(data.getZcglryjt()));
        tv_gljt.setText(String.valueOf(data.getGljt()));
        tv_tsjt.setText(String.valueOf(data.getGjtsjt()));
        tv_xljt.setText(String.valueOf(data.getXljt()));
        tv_zcjt.setText(String.valueOf(data.getZcjt()));
        tv_dhfbz.setText(String.valueOf(data.getDhbj()));
        tv_snwcf.setText(String.valueOf(data.getSnwcf()));
        tv_snjtf.setText(String.valueOf(data.getSnjtf()));
        tv_wybt.setText(String.valueOf(data.getWybt()));
        tv_bsjkk.setText(String.valueOf(data.getBsjkk()));
        tv_lsfy.setText(String.valueOf(data.getLsfy()));
        tv_yfgz.setText(String.valueOf(data.getYfgz()));
        tv_sbkk.setText(String.valueOf(data.getSbje()));
        tv_sbtsqk.setText(String.valueOf(data.getSbtsqk()));
        tv_gskk.setText(String.valueOf(data.getGskk()));
        tv_jle.setText(String.valueOf(data.getJle()));
        tv_user_name.setText(data.getUsername());
        tv_qz.setText(data.getUserqz());
        tv_zqz.setText(data.getDepartbm());
        tv_jzgw.setText(data.getJobsgw());
        tv_zyxl.setText(data.getGlzy());
        tv_gj.setText(data.getGj());
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_wages_detail;
    }
}