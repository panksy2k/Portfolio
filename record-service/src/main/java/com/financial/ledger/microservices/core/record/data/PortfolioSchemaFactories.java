package com.financial.ledger.microservices.core.record.data;

import com.financial.ledger.microservices.core.record.domain.PortfolioSchema;

public enum PortfolioSchemaFactories implements PortfolioSchemaFactory {
    ASSETS(new AssetPortfolioFactory()),
    LIABILITIES(new LiabilityPortfolioFactory()),
    CREDENTIALS(new CredentialsPortfolioFactory());

    private PortfolioSchemaFactory pf;
    private PortfolioSchemaFactories(PortfolioSchemaFactory theParticularFactory) {
        this.pf = theParticularFactory;
    }

    @Override
    public PortfolioSchema create() {
        return this.pf.create();
    }
}
