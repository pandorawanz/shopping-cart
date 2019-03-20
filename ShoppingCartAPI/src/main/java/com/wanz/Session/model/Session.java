package com.wanz.Session.model;

public class Session {
    private int userId;
    private String token;

    public Session() {}

    public Session(int userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String
    getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
