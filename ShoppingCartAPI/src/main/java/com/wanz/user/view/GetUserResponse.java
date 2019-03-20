package com.wanz.user.view;

import com.wanz.user.model.User;

public class GetUserResponse {
    private User user;

    public GetUserResponse() {}

    public GetUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
