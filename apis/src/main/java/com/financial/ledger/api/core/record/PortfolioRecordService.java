package com.financial.ledger.api.core.record;

import com.financial.ledger.api.core.attributes.PortfolioAttribute;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

public interface PortfolioRecordService {
    @GetMapping(value = "/types", produces = "application/json")
    List<String> getPortfolioTypes();

    @GetMapping(value = "/type/fields", produces = "application/json")
    List<PortfolioAttribute> getFieldsByPortfolioType(String portfolioTypeDescription);

    PortfolioRecords createPortfolioRecords(PortfolioRecords completeRecords);

    @GetMapping(value = "/record", produces = "application/json")
    Flux<PortfolioRecords> getPortfolioRecordsByUserId(@RequestParam(value = "portfolioUserId", required = true)
                                                       String portfolioUserId);
    void deleteRecords(@RequestParam(value = "portfolioUserId", required = true) String portfolioUserId);
}
