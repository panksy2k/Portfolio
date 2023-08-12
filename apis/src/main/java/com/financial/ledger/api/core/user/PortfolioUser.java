package com.financial.ledger.api.core.user;

public class PortfolioUser {
    private String userId;
    private String username;
    private String personalName;
    private String serviceAddress;

    public PortfolioUser() {
        this.userId = null;
        this.username = null;
        this.personalName = null;
        this.serviceAddress = null;
    }

    public PortfolioUser(String userId, String username, String personalName, String serviceAddress) {
        this.userId = userId;
        this.username = username;
        this.personalName = personalName;
        this.serviceAddress = serviceAddress;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPersonalName() {
        return personalName;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
