package com.financial.ledger.microservices.core.record.data;

import com.financial.ledger.microservices.core.record.domain.PortfolioSchema;
import com.financial.ledger.util.exceptions.InvalidInputException;

public interface PortfolioSchemaFactory {
    PortfolioSchema create();

    public static PortfolioSchema getSchema(String typeName) {
        switch (typeName) {
            case "asset": return PortfolioSchemaFactories.ASSETS.create();
            case "liability": return PortfolioSchemaFactories.LIABILITIES.create();
            case "credentials": return PortfolioSchemaFactories.CREDENTIALS.create();
            default: throw new InvalidInputException("Portfolio Type is unknown");
        }
    }
}
