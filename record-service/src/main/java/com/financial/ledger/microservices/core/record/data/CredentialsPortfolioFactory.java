package com.financial.ledger.microservices.core.record.data;

import static com.financial.ledger.microservices.core.record.domain.AttributeNames.LOGIN_ID;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.PASSWORD;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.PROVIDER_NAME;
import com.financial.ledger.microservices.core.record.domain.PortfolioSchema;
import com.financial.ledger.microservices.core.record.domain.PortfolioSchemaBuilder;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import java.util.List;

public class CredentialsPortfolioFactory implements PortfolioSchemaFactory {
    @Override
    public PortfolioSchema create() {
        List<PortfolioSchema> credentialsAttributes = PortfolioSchemaBuilder.basic()
                .withAttribute(PortfolioType.LIABILITY, LOGIN_ID)
                .withAttribute(PortfolioType.LIABILITY, PASSWORD)
                .withAttribute(PortfolioType.LIABILITY, PROVIDER_NAME)
                .build();

        return credentialsAttributes.iterator().next();
    }
}
