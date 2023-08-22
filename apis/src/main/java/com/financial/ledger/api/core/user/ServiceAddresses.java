package com.financial.ledger.api.core.user;

public class ServiceAddresses {
    private final String cmppuAddress;
    private final String puAddress;

    public ServiceAddresses(String cmppuAddress, String puAddress) {
        this.cmppuAddress = cmppuAddress;
        this.puAddress = puAddress;
    }

    public String getCmppuAddress() {
        return cmppuAddress;
    }

    public String getPuAddress() {
        return puAddress;
    }
}
