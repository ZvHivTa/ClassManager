package com.zht.pojo;

public class User {
    private Integer account;
    private String password;
    private Integer type;

    public User(Integer account, String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "account=" + account +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

    public User() {
    }

    public User(Integer account, String password, Integer type) {
        this.account = account;
        this.password = password;
        this.type = type;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
