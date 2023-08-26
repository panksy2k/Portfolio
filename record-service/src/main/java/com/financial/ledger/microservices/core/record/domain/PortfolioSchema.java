package com.financial.ledger.microservices.core.record.domain;

import java.util.Collections;
import java.util.List;

public class PortfolioSchema implements Schema {
    private final PortfolioType type;
    private final List<AttributeNames> attributes;

    public PortfolioSchema(PortfolioType type, List<AttributeNames> attributes) {
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
    public List<AttributeNames> attributes() {
        return this.attributes;
    }
}
