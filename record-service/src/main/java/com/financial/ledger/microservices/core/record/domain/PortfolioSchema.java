package com.financial.ledger.microservices.core.record.domain;

import java.util.Collections;
import java.util.List;

public class PortfolioSchema implements Schema {
    private final PortfolioType type;
    private final List<String> attributes;

    public PortfolioSchema(PortfolioType type, List<String> attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public PortfolioSchema(PortfolioType type) {
        this.type = type;
        this.attributes = Collections.emptyList();
    }

    @Override
    public PortfolioType type() {
        return this.type;
    }

    @Override
    public List<String> attributes() {
        return this.attributes;
    }
}
