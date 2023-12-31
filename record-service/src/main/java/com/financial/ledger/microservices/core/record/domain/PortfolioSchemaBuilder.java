package com.financial.ledger.microservices.core.record.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PortfolioSchemaBuilder {
    private Map<PortfolioType, Set<String>> schemaItem =
            new HashMap<>();

    public static PortfolioSchemaBuilder basic() {
        return new PortfolioSchemaBuilder();
    }

    public PortfolioSchemaBuilder withAttribute(PortfolioType portfolioType,
                                                String portfolioAttribute) {
        if(schemaItem.containsKey(portfolioType)) {
            Set<String> temp = schemaItem.get(portfolioType);
            temp.add(portfolioAttribute);
        } else {
            schemaItem.put(portfolioType, Set.of(portfolioAttribute));
        }

        return this;
    }

    public List<PortfolioSchema> build() {
        List<PortfolioSchema> portfolioSchemaList = new ArrayList<>();

        if(schemaItem.isEmpty()) {
            return Collections.<PortfolioSchema>emptyList();
        }

        for(Map.Entry<PortfolioType, Set<String>> item :
                schemaItem.entrySet()) {
            portfolioSchemaList.add(new PortfolioSchema(item.getKey(), item.getValue().stream().toList()));
        }

        return portfolioSchemaList;
    }
}
