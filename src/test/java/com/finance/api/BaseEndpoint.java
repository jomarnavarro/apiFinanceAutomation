package com.finance.api;

public class BaseEndpoint {

    private String baseUrl;
    private String token;

    public BaseEndpoint(String baseUrl, String token) {
        this.baseUrl = baseUrl;
        this.token = token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
