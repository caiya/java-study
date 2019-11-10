package com.codeshop.spring.starter.demo;

public class UserClient {
    private UserProperties userProperties;

    public UserClient() {}

    public UserClient(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public String getName() {
        return userProperties.getName();
    }
}
