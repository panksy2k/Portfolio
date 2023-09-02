package com.financial.ledger.microservices.core.record.data;

import static com.financial.ledger.microservices.core.record.domain.AttributeNames.ACCOUNT_BALANCE;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.ACCOUNT_EXPIRY;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.ACCOUNT_NUMBER;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.ADDRESS;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.CONTACT_PHONE;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.DETAILS;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.MONTHLY_PAYMENT;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.NAME;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.PROVIDER_NAME;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.REMAINING_TERM;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.ROI;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.SORT_CODE;
import static com.financial.ledger.microservices.core.record.domain.AttributeNames.WEBSITE;
import com.financial.ledger.microservices.core.record.domain.PortfolioSchema;
import com.financial.ledger.microservices.core.record.domain.PortfolioSchemaBuilder;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import java.util.List;

public class LiabilityPortfolioFactory implements PortfolioSchemaFactory {
    @Override
    public PortfolioSchema create() {
        List<PortfolioSchema> assetAttributes = PortfolioSchemaBuilder.basic()
                .withAttribute(PortfolioType.LIABILITY, NAME)
                .withAttribute(PortfolioType.LIABILITY, ACCOUNT_NUMBER)
                .withAttribute(PortfolioType.LIABILITY, PROVIDER_NAME)
                .withAttribute(PortfolioType.LIABILITY, ACCOUNT_BALANCE)
                .withAttribute(PortfolioType.LIABILITY, MONTHLY_PAYMENT)
                .withAttribute(PortfolioType.LIABILITY, WEBSITE)
                .withAttribute(PortfolioType.LIABILITY, ROI)
                .withAttribute(PortfolioType.LIABILITY, ACCOUNT_EXPIRY)
                .withAttribute(PortfolioType.LIABILITY, REMAINING_TERM)
                .withAttribute(PortfolioType.LIABILITY, CONTACT_PHONE)
                .build();

        return assetAttributes.iterator().next();
    }
}
