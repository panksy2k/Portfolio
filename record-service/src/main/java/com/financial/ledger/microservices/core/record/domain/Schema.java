package com.financial.ledger.microservices.core.record.domain;

import java.util.List;

public interface Schema {
    PortfolioType type();

    List<String> attributes();
}
