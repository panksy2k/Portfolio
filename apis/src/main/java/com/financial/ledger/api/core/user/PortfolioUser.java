package com.financial.ledger.api.core.user;

public class PortfolioUser {
    private String id;
    private String username;
    private String personalName;
    private String serviceAddress;

    public PortfolioUser() {
        this.id = null;
        this.username = null;
        this.personalName = null;
        this.serviceAddress = null;
    }

    public PortfolioUser(String id, String username, String personalName, String serviceAddress) {
        this.id = id;
        this.username = username;
        this.personalName = personalName;
        this.serviceAddress = serviceAddress;
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

    public String getId() {
        return id;
    }
}
