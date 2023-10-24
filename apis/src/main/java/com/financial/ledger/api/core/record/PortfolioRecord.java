package com.financial.ledger.api.core.record;

import java.util.Map;

public class PortfolioRecord {
    private String portfolioUserID;
    private String recordType;
    private Map<String, String> recordAttributeNameValue;

    public String getPortfolioUserID() {
        return portfolioUserID;
    }

    public void setPortfolioUserID(String portfolioUserID) {
        this.portfolioUserID = portfolioUserID;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Map<String, String> getRecordAttributeNameValue() {
        return recordAttributeNameValue;
    }

    public void setRecordAttributeNameValue(Map<String, String> recordAttributeNameValue) {
        this.recordAttributeNameValue = recordAttributeNameValue;
    }

    public void validateFields() {
        Map<String, String> recordAttributeNameValue1 = getRecordAttributeNameValue();
        if(recordAttributeNameValue1 != null && !recordAttributeNameValue1.isEmpty()) {
            for(String fieldName : recordAttributeNameValue1.keySet()) {
                String fieldValue = recordAttributeNameValue1.get(fieldName);


            }
        }

    }
}
