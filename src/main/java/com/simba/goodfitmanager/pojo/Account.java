package com.simba.goodfitmanager.pojo;

public class Account {
    private String accountName;

    private String password;

    private Integer role;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public Account() {
    }

    public Account(String accountName, String password, Integer role) {
        this.accountName = accountName;
        this.password = password;
        this.role = role;
    }
}