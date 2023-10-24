package com.financial.ledger.microservices.core.record.service;

import com.financial.ledger.api.core.attributes.PortfolioAttribute;
import com.financial.ledger.api.core.record.PortfolioRecord;
import com.financial.ledger.api.core.record.PortfolioRecordService;
import com.financial.ledger.api.core.record.PortfolioRecords;
import com.financial.ledger.microservices.core.record.data.PortfolioDataTypes;
import com.financial.ledger.microservices.core.record.domain.Field;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import com.financial.ledger.microservices.core.record.helper.PortfolioHelper;
import com.financial.ledger.util.exceptions.InvalidInputException;
import com.financial.ledger.util.exceptions.NotFoundException;
import io.micrometer.common.util.StringUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
            throw new InvalidInputException("Portfolio Type should not be null");
        }

        try {
            List<Field> fieldsByPortfolioType = PortfolioHelper.getFields(typeDescription);
            if(fieldsByPortfolioType == null || fieldsByPortfolioType.isEmpty()) {
                throw new NotFoundException("Un-recognized Portfolio Type!");
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
        if(completeRecords == null || completeRecords.getCompleteRecordSet() == null) {
            throw new InvalidInputException("Invalid portfolio entry -- cannot create one!");
        }

        for(PortfolioRecord rec : completeRecords.getCompleteRecordSet()) {
            String recordType = rec.getRecordType();
            if(StringUtils.isBlank(recordType)) {
                throw new InvalidInputException("Portfolio Type not known -- cannot validate");
            }

            List<Field> fieldsSchemaByPortfolioType = PortfolioHelper.getFields(recordType);
            if(fieldsSchemaByPortfolioType != null && fieldsSchemaByPortfolioType.isEmpty()) {
                throw new NotFoundException("Cannot find fields for type: " + recordType);
            }

            Map<String, String> actualFieldsAndValueByPortfolioType = rec.getRecordAttributeNameValue();

            //Check all expected fields
            List<String> missingFields = PortfolioHelper.compareFieldsByName(fieldsSchemaByPortfolioType
                            .stream().map(Field::name).collect(Collectors.toList()),
                    actualFieldsAndValueByPortfolioType.keySet());

            if(missingFields.isEmpty()) {
                throw new NotFoundException("Cannot find fields in request -- " + missingFields);
            }

            //Validate all field values

        }

        return null;


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
