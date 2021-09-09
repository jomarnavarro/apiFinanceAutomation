package com.finance.pojo.api;

public class BuyResponseBody {

    String message;

    public BuyResponseBody(String message) {
        this.message = message;
    }

    public BuyResponseBody() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
