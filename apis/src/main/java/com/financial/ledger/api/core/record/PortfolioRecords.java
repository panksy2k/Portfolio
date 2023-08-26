package com.financial.ledger.api.core.record;

import java.util.List;

public class PortfolioRecords {
    private List<PortfolioRecord> completeRecordSet;

    public List<PortfolioRecord> getCompleteRecordSet() {
        return completeRecordSet;
    }

    public void setCompleteRecordSet(List<PortfolioRecord> completeRecordSet) {
        this.completeRecordSet = completeRecordSet;
    }
}
