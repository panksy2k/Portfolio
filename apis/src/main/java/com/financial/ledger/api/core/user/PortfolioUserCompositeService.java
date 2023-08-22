package com.financial.ledger.api.core.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;

@Api(description = "REST API for composite UserPortfolio information")
public interface PortfolioUserCompositeService {

    @PostMapping(value = "/userportfolio-composite", consumes = "application/json")
    void createCompositePortfolioUser();
}
