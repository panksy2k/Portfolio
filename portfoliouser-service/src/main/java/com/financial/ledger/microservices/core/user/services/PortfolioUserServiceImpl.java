package com.financial.ledger.microservices.core.user.services;

import com.financial.ledger.api.core.user.PortfolioUser;
import com.financial.ledger.api.core.user.PortfolioUserService;
import com.financial.ledger.microservices.core.user.persistence.PortfolioUsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioUserServiceImpl implements PortfolioUserService {
    private final static Logger LOG = LoggerFactory.getLogger(PortfolioUserServiceImpl.class);

    private final PortfolioUsersRepository repository;

    @Autowired
    public PortfolioUserServiceImpl(PortfolioUsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioUser createPortfolioUser(PortfolioUser newUser) {
        return null;
    }

    @Override
    public PortfolioUser getPortfolio(int portfolioUserId) {
        return null;
    }

    @Override
    public void deletePortfolioUser(int portfolioUserId) {

    }
}
