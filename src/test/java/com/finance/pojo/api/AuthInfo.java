package com.finance.pojo.api;

public class AuthInfo {

    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthInfo(String token) {
        this.token = token;
    }

    public AuthInfo() {
    }

}
