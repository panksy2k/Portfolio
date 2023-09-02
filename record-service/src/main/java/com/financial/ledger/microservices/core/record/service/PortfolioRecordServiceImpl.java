package com.financial.ledger.microservices.core.record.service;

import com.financial.ledger.api.core.record.PortfolioRecordService;
import com.financial.ledger.api.core.record.PortfolioRecords;
import com.financial.ledger.microservices.core.record.data.PortfolioSchemaFactory;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import com.financial.ledger.util.exceptions.InvalidInputException;
import java.util.ArrayList;
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
        return Arrays.stream(PortfolioType.values()).map(PortfolioType::name).collect(Collectors.toList());
    }

    @Override
    public List<String> getAttributesByPortfolioType(String type) {
        if(type == null) {
            throw new InvalidInputException("Portfolio Type is in-correct");
        }

        try {
            return PortfolioSchemaFactory.getSchema(type).attributes();
        } catch(Exception e) {
            LOG.error("Error when fetching attributes for portfolio type", e);
            throw e;
        }
    }

    @Override
    public PortfolioRecords createPortfolioRecords(PortfolioRecords completeRecords) {
        return null;
    }

    @Override
    public Flux<PortfolioRecords> getPortfolioRecordsByUserId(String portfolioUserId) {
        return null;
    }

    @Override
    public void deleteRecords(String portfolioUserId) {

    }
}
