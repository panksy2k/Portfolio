package com.financial.ledger.microservices.core.record.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="portfoliorecords")
public class PortfolioRecordEntity {
    @Id
    private String portfolioRecordId;
    private String attributeName;
    private String attributeContentValue;
    private String userName;
    @Version
    private Integer version;

    public PortfolioRecordEntity() {}

    public PortfolioRecordEntity(String portfolioRecordId, String attributeName, String attributeContentValue,
                                 String userName) {
        this.portfolioRecordId = portfolioRecordId;
        this.attributeName = attributeName;
        this.attributeContentValue = attributeContentValue;
        this.userName = userName;
    }

    public String getPortfolioRecordId() {
        return portfolioRecordId;
    }

    public void setPortfolioRecordId(String portfolioRecordId) {
        this.portfolioRecordId = portfolioRecordId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeContentValue() {
        return attributeContentValue;
    }

    public void setAttributeContentValue(String attributeContentValue) {
        this.attributeContentValue = attributeContentValue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
