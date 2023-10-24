package com.financial.ledger.microservices.core.record.helper;

import com.financial.ledger.microservices.core.record.data.PortfolioDataTypes;
import com.financial.ledger.microservices.core.record.domain.AccountType;
import com.financial.ledger.microservices.core.record.domain.Field;
import com.financial.ledger.microservices.core.record.domain.Field.ValidationOutput;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import com.financial.ledger.util.Strings;
import com.financial.ledger.util.exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PortfolioHelper {
    private static final Logger LOG = LoggerFactory.getLogger(PortfolioHelper.class);

    public static List<Field> getFields(String portfolioTypeDesc) {
        PortfolioType portfolioType = PortfolioType.byDescription(portfolioTypeDesc);
        if(portfolioType == null) {
            throw new NotFoundException("Portfolio Type was not found!");
        }

        Field.Set all = PortfolioDataTypes.combinedPortfolioType;

        return all.fetchFieldsByPortfolioType(portfolioType);
    }

    public static List<String> compareFieldsByName(List<String> expectedFields, Set<String> actualFieldNames) {
        List<String> fieldNamesUnavailable = new ArrayList<>();
        for(String expectedFld : expectedFields) {
            if(!actualFieldNames.contains(expectedFld)) {
                fieldNamesUnavailable.add(expectedFld);
            }
        }

        return fieldNamesUnavailable.size() == 0? Collections.emptyList() : fieldNamesUnavailable;
    }

    public static int validateFieldNullable(Field theField, String value) {
        if(Strings.isNullOrBlank(value)) {
            LOG.error("{} should not be empty!", theField.displayName());
            return 1;
        }

        return 0;
    }

    public static int validateAccountTypeField(Field theField, String value) {
        if(Strings.isNullOrBlank(value)) {
            LOG.error("{} should not be empty!", theField.displayName());
            return 1;
        }

        try {
            return AccountType.valueOf(value.toUpperCase()) == null? 1 : 0;
        } catch(IllegalArgumentException e) {
            return 1;
        }
    }

    public static int validateFieldNumeric(Field theField, String value) {
        if(!Strings.isNumeric(value)) {
            LOG.error("{} should be numeric!", theField.displayName());
            return 1;
        }

        return 0;
    }
}
