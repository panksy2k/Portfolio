package com.financial.ledger.api.core.attributes;

public class PortfolioAttribute {
    private String name;
    private String displayName;

    public PortfolioAttribute(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
