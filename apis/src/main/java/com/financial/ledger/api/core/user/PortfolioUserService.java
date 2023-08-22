package com.financial.ledger.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface PortfolioUserService {
    PortfolioUser createPortfolioUser(@RequestBody PortfolioUser newUser);

    @GetMapping(value = "/portfolio/user/{portfolioUserId}", produces = "application/json")
    Mono<PortfolioUser> getPortfolio(@PathVariable String portfolioUserId);

    void deletePortfolioUser(@PathVariable String portfolioUserId);
}
