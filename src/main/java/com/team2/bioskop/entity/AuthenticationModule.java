package com.team2.bioskop.entity;

public class AuthenticationModule {
    String loginCheck;

    public AuthenticationModule(String loginCheck) {
        this.loginCheck = loginCheck;
    }

    public String getLoginCheck() {
        return loginCheck;
    }
}
