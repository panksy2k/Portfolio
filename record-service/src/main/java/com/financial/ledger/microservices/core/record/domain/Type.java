package com.financial.ledger.microservices.core.record.domain;

public enum Type {
    BOOLEAN,
    STRING,
    INT,
    DOUBLE,
    PASSWORD;

    private Type() {}

    public boolean isSensitive() {
        return this == PASSWORD;
    }
}
