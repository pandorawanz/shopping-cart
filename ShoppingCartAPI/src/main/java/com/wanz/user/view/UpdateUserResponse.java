package com.wanz.user.view;

import com.wanz.user.model.User;

public class UpdateUserResponse {
    private User user;

    public UpdateUserResponse() {}

    public UpdateUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
