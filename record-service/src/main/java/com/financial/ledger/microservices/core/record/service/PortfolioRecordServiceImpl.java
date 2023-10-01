package com.financial.ledger.microservices.core.record.service;

import com.financial.ledger.api.core.attributes.PortfolioAttribute;
import com.financial.ledger.api.core.record.PortfolioRecordService;
import com.financial.ledger.api.core.record.PortfolioRecords;
import com.financial.ledger.microservices.core.record.data.PortfolioDataTypes;
import com.financial.ledger.microservices.core.record.domain.Field;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import com.financial.ledger.util.exceptions.InvalidInputException;
import com.financial.ledger.util.exceptions.NotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PortfolioRecordServiceImpl implements PortfolioRecordService {
    private static final Logger LOG = LoggerFactory.getLogger(PortfolioRecordServiceImpl.class);

    @Override
    public List<String> getPortfolioTypes() {
        return Arrays.stream(PortfolioType.values()).map(PortfolioType::description).collect(Collectors.toList());
    }

    @Override
    public List<PortfolioAttribute> getFieldsByPortfolioType(String typeDescription) {
        if(typeDescription == null) {
            throw new InvalidInputException("Portfolio Type Description should not be null");
        }

        try {
            PortfolioType portfolioType = PortfolioType.byDescription(typeDescription);
            if(portfolioType == null) {
                throw new NotFoundException("Portfolio Type was not found!");
            }

            Field.Set all = PortfolioDataTypes.combinedPortfolioType;
            List<Field> fieldsByPortfolioType = all.fetchFieldsByPortfolioType(portfolioType);
            if(fieldsByPortfolioType == null || fieldsByPortfolioType.isEmpty()) {
                throw new NotFoundException("Portfolio Type was not found!");
            }

            return fieldsByPortfolioType.stream()
                    .map(f -> new PortfolioAttribute(f.name(), f.displayName()))
                    .collect(Collectors.toList());
        } catch(Exception e) {
            LOG.error("Error when fetching attributes for portfolio type", e);
            throw e;
        }
    }

    @Override
    public PortfolioRecords createPortfolioRecords(PortfolioRecords completeRecords) {
        throw new RuntimeException("Implement me");
    }

    @Override
    public Flux<PortfolioRecords> getPortfolioRecordsByUserId(String portfolioUserId) {
        throw new RuntimeException("Implement me");
    }

    @Override
    public void deleteRecords(String portfolioUserId) {
        throw new RuntimeException("Implement me");
    }
}
