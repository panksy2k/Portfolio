package com.financial.ledger.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PortfolioUserService {
    PortfolioUser createPortfolioUser(@RequestBody PortfolioUser newUser);

    @GetMapping(value = "/portfolio/user/{portfolioUserId}", produces = "application/json")
    PortfolioUser getPortfolio(@PathVariable int portfolioUserId);

    void deletePortfolioUser(@PathVariable int portfolioUserId);
}
