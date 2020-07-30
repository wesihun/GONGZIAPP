package com.winto.develop.wages.bean;

import com.winto.develop.wages.base.BaseResponse;

import java.util.List;

public class WagesListBean extends BaseResponse {
    /**
     * code : 200
     * data : [{"id":"0084270b-800f-45c9-a4a3-c977ae0f5d9c","username":"汪晓红","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300.12,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"02666b92-6b52-4f1b-997e-a27085814f82","username":"钱艳芳","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300.11,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"08e6ea0d-b0e4-4b99-9c00-c105db5ca80a","username":"刘一","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300.1,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"0a178f59-8514-4333-9d57-785f5b2ee7f6","username":"马文学","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"0bbc3990-ed91-41d6-807e-d8c26325349f","username":"侯兴州","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"0d86aa53-b066-4e8d-8a03-b280d47823ef","username":"乔佳鑫","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"0ec5c249-9408-49db-b9f8-b55522e819f1","username":"高广婷","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"},{"id":"0f3d800f-9b54-4bbf-950b-1190a9e5a325","username":"郭海霞","userqz":"的","departbm":"的","jobsgw":"的","glzy":"的","gj":"的","gwjbgz":2000,"jz":200,"zcglryjt":100,"gljt":100,"gjtsjt":100,"xljt":200,"zcjt":300,"dhbj":50,"snwcf":1,"snjtf":0,"wybt":0,"bsjkk":0,"lsfy":-50,"yfgz":3001,"sbje":0,"sbtsqk":0,"gskk":1,"jle":3000,"batchid":"47fdb282-9e99-4906-83b6-e4c07ff7a629","yearmonth":"2020-01","createtime":"2020-07-29T15:06:51"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 0084270b-800f-45c9-a4a3-c977ae0f5d9c
         * username : 汪晓红
         * userqz : 的
         * departbm : 的
         * jobsgw : 的
         * glzy : 的
         * gj : 的
         * gwjbgz : 2000
         * jz : 200
         * zcglryjt : 100
         * gljt : 100
         * gjtsjt : 100
         * xljt : 200
         * zcjt : 300.12
         * dhbj : 50
         * snwcf : 1
         * snjtf : 0
         * wybt : 0
         * bsjkk : 0
         * lsfy : -50
         * yfgz : 3001
         * sbje : 0
         * sbtsqk : 0
         * gskk : 1
         * jle : 3000
         * batchid : 47fdb282-9e99-4906-83b6-e4c07ff7a629
         * yearmonth : 2020-01
         * createtime : 2020-07-29T15:06:51
         */

        private String id;
        private String username;
        private String userqz;
        private String departbm;
        private String jobsgw;
        private String glzy;
        private String gj;
        private int gwjbgz;
        private int jz;
        private int zcglryjt;
        private int gljt;
        private int gjtsjt;
        private int xljt;
        private double zcjt;
        private int dhbj;
        private int snwcf;
        private int snjtf;
        private int wybt;
        private int bsjkk;
        private int lsfy;
        private int yfgz;
        private int sbje;
        private int sbtsqk;
        private int gskk;
        private int jle;
        private String batchid;
        private String yearmonth;
        private String createtime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserqz() {
            return userqz;
        }

        public void setUserqz(String userqz) {
            this.userqz = userqz;
        }

        public String getDepartbm() {
            return departbm;
        }

        public void setDepartbm(String departbm) {
            this.departbm = departbm;
        }

        public String getJobsgw() {
            return jobsgw;
        }

        public void setJobsgw(String jobsgw) {
            this.jobsgw = jobsgw;
        }

        public String getGlzy() {
            return glzy;
        }

        public void setGlzy(String glzy) {
            this.glzy = glzy;
        }

        public String getGj() {
            return gj;
        }

        public void setGj(String gj) {
            this.gj = gj;
        }

        public int getGwjbgz() {
            return gwjbgz;
        }

        public void setGwjbgz(int gwjbgz) {
            this.gwjbgz = gwjbgz;
        }

        public int getJz() {
            return jz;
        }

        public void setJz(int jz) {
            this.jz = jz;
        }

        public int getZcglryjt() {
            return zcglryjt;
        }

        public void setZcglryjt(int zcglryjt) {
            this.zcglryjt = zcglryjt;
        }

        public int getGljt() {
            return gljt;
        }

        public void setGljt(int gljt) {
            this.gljt = gljt;
        }

        public int getGjtsjt() {
            return gjtsjt;
        }

        public void setGjtsjt(int gjtsjt) {
            this.gjtsjt = gjtsjt;
        }

        public int getXljt() {
            return xljt;
        }

        public void setXljt(int xljt) {
            this.xljt = xljt;
        }

        public double getZcjt() {
            return zcjt;
        }

        public void setZcjt(double zcjt) {
            this.zcjt = zcjt;
        }

        public int getDhbj() {
            return dhbj;
        }

        public void setDhbj(int dhbj) {
            this.dhbj = dhbj;
        }

        public int getSnwcf() {
            return snwcf;
        }

        public void setSnwcf(int snwcf) {
            this.snwcf = snwcf;
        }

        public int getSnjtf() {
            return snjtf;
        }

        public void setSnjtf(int snjtf) {
            this.snjtf = snjtf;
        }

        public int getWybt() {
            return wybt;
        }

        public void setWybt(int wybt) {
            this.wybt = wybt;
        }

        public int getBsjkk() {
            return bsjkk;
        }

        public void setBsjkk(int bsjkk) {
            this.bsjkk = bsjkk;
        }

        public int getLsfy() {
            return lsfy;
        }

        public void setLsfy(int lsfy) {
            this.lsfy = lsfy;
        }

        public int getYfgz() {
            return yfgz;
        }

        public void setYfgz(int yfgz) {
            this.yfgz = yfgz;
        }

        public int getSbje() {
            return sbje;
        }

        public void setSbje(int sbje) {
            this.sbje = sbje;
        }

        public int getSbtsqk() {
            return sbtsqk;
        }

        public void setSbtsqk(int sbtsqk) {
            this.sbtsqk = sbtsqk;
        }

        public int getGskk() {
            return gskk;
        }

        public void setGskk(int gskk) {
            this.gskk = gskk;
        }

        public int getJle() {
            return jle;
        }

        public void setJle(int jle) {
            this.jle = jle;
        }

        public String getBatchid() {
            return batchid;
        }

        public void setBatchid(String batchid) {
            this.batchid = batchid;
        }

        public String getYearmonth() {
            return yearmonth;
        }

        public void setYearmonth(String yearmonth) {
            this.yearmonth = yearmonth;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }
    }
}
