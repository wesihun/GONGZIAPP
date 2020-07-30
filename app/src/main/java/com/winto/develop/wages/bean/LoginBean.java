package com.winto.develop.wages.bean;

import com.winto.develop.wages.base.BaseResponse;

public class LoginBean extends BaseResponse {

    /**
     * code : 200
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOiIxNTk2MDczMzA5IiwiZXhwIjoxNTk2MDc1MTA5LCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IuWtlOWHoeaYnyIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTAwMCIsImF1ZCI6IuWtlOWHoeaYnzEyMzQ1NjIwMjAvNy8zMCA5OjQxOjQ5In0.Tv4NBECF-ndiIt-nn4DGAfiopkkTi9lUHCwr8FbhIRI
     */

    private int code;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
