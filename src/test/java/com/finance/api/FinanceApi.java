package com.finance.api;

public class FinanceApi {

    private LoginEndpoint loginEndpoint;
    private BuyEndpoint buyEndpoint;
    private SellEndpoint sellEndpoint;
    private RegisterEndpoint registerEndpoint;
    private String baseUrl;

    public FinanceApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public LoginEndpoint loginEndpoint() {
        if(loginEndpoint == null)
            loginEndpoint = new LoginEndpoint(this.baseUrl);

        return loginEndpoint;
    }

    public BuyEndpoint buyEndpoint() throws Exception {
        if(loginEndpoint == null)
            throw new Exception("You need to log in first!");
        if(buyEndpoint == null)
            buyEndpoint = new BuyEndpoint(loginEndpoint.getBaseUrl(), loginEndpoint.getToken());
        return buyEndpoint;
    }

    public SellEndpoint sellEndpoint() throws Exception {
        if(loginEndpoint == null)
            throw new Exception("You need to log in first!");
        if(sellEndpoint == null)
            sellEndpoint = new SellEndpoint(loginEndpoint.getBaseUrl(), loginEndpoint.getToken());
        return sellEndpoint;
    }

    public RegisterEndpoint registerEndpoint() throws Exception {
        if(loginEndpoint == null)
            throw new Exception("You need to log in first!");
        if(registerEndpoint == null)
            registerEndpoint = new RegisterEndpoint(loginEndpoint.getBaseUrl(), loginEndpoint.getToken());
        return registerEndpoint;
    }


}
