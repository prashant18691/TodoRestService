package com.prs.webservice.helloworldservice.basicAuth;

public class AuthenticationBean {
    String message;
    public AuthenticationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
