package com.financial.ledger.api.core.record;

import com.financial.ledger.api.core.attributes.PortfolioAttribute;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

public interface PortfolioRecordService {
    @GetMapping(value = "/types", produces = "application/json")
    List<String> getPortfolioTypes();

    @GetMapping(value = "/type/fields", produces = "application/json")
    List<PortfolioAttribute> getFieldsByPortfolioType(String portfolioTypeDescription);

    @GetMapping(value = "/record", produces = "application/json")
    Flux<PortfolioRecords> getPortfolioRecordsByUserId(@RequestParam(value = "portfolioUserId", required = true)
                                                       String portfolioUserId);

    @PostMapping(produces = "application/json")
    PortfolioRecords createPortfolioRecords(PortfolioRecords completeRecords);

    void deleteRecords(@RequestParam(value = "portfolioUserId", required = true) String portfolioUserId);
}
