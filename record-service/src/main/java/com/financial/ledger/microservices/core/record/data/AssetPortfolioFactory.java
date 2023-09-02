package com.financial.ledger.microservices.core.record.data;

import static com.financial.ledger.microservices.core.record.domain.AttributeNames.*;
import com.financial.ledger.microservices.core.record.domain.PortfolioSchema;
import com.financial.ledger.microservices.core.record.domain.PortfolioSchemaBuilder;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import java.util.List;

public class AssetPortfolioFactory implements PortfolioSchemaFactory {
    @Override
    public PortfolioSchema create() {
        List<PortfolioSchema> assetAttributes = PortfolioSchemaBuilder.basic()
                .withAttribute(PortfolioType.ASSET, ACCOUNT_NUMBER)
                .withAttribute(PortfolioType.ASSET, SORT_CODE)
                .withAttribute(PortfolioType.ASSET, PROVIDER_NAME)
                .withAttribute(PortfolioType.ASSET, NAME)
                .withAttribute(PortfolioType.ASSET, WEBSITE)
                .withAttribute(PortfolioType.ASSET, ACCOUNT_BALANCE)
                .withAttribute(PortfolioType.ASSET, MONTHLY_PAYMENT)
                .withAttribute(PortfolioType.ASSET, ADDRESS)
                .withAttribute(PortfolioType.ASSET, DETAILS)
                .build();

        return assetAttributes.iterator().next();
    }
}
