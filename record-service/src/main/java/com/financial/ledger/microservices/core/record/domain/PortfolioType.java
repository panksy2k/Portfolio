package com.financial.ledger.microservices.core.record.domain;

public enum PortfolioType {
    BANK_ACCOUNT("Bank Account"),
    PENSION("Pension"),
    TRADING_ACCOUNT("Trading Account"),
    PROPERTY("House/Property"),
    CREDIT_CARD("Credit Card"),
    INSURANCE_COVER("Insurance/Cover"),
    SUBSCRIPTIONS("Subscription"),
    AGENCY("Private Agency");

    private final String description;

    PortfolioType(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }

    public static PortfolioType byDescription(String description) {
        for (PortfolioType t : PortfolioType.values()) {
            if (description != null && t.description().equalsIgnoreCase(description)) {
                return t;
            }
        }

        return null;
    }
}

