package com.financial.ledger.microservices.core.user.services;

import com.financial.ledger.api.core.user.PortfolioUser;
import com.financial.ledger.api.core.user.PortfolioUserService;
import com.financial.ledger.microservices.core.user.persistence.PortfolioUserEntity;
import com.financial.ledger.microservices.core.user.persistence.PortfolioUsersRepository;
import com.financial.ledger.util.Strings;
import com.financial.ledger.util.exceptions.InvalidInputException;
import com.financial.ledger.util.exceptions.NotFoundException;
import com.financial.ledger.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PortfolioUserServiceImpl implements PortfolioUserService {
    private final static Logger LOG = LoggerFactory.getLogger(PortfolioUserServiceImpl.class);

    private final PortfolioUsersRepository repository;
    private final ServiceUtil serviceUtil;

    @Autowired
    public PortfolioUserServiceImpl(PortfolioUsersRepository repository, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public PortfolioUser createPortfolioUser(PortfolioUser newUser) {
        if(newUser == null || !StringUtils.hasText(newUser.getUsername())) {
            throw new RuntimeException("Invalid username whilst creating portfolio user");
        }

        final PortfolioUserEntity e = new PortfolioUserEntity();
        e.setPersonalName(newUser.getPersonalName());
        e.setUserName(newUser.getUsername());

        Mono<PortfolioUserEntity> savedUser = repository.save(e);

        return savedUser.onErrorMap(DuplicateKeyException.class,
                        de -> new InvalidInputException("Portfolio Username already exist " + newUser.getUsername()))
                .map(upe -> new PortfolioUser(
                        newUser.getId(),
                        newUser.getUsername(),
                        newUser.getPersonalName(),
                        null))
                .block();
    }

    @Override
    public Mono<PortfolioUser> getPortfolio(String portfolioUserId) {
        if(!StringUtils.hasText(portfolioUserId)) {
            throw new InvalidInputException("Invalid portfolio Id");
        }

        Mono<PortfolioUserEntity> user = this.repository.findById(portfolioUserId);
        return user.switchIfEmpty(
                        Mono.error(() -> new NotFoundException("The user with id do not exist " + portfolioUserId)))
                .log()
                .map(eu -> new PortfolioUser(eu.getUserID(), eu.getUserName(), eu.getPersonalName(),
                        serviceUtil.getServiceAddress()));
    }

    @Override
    public void deletePortfolioUser(String portfolioUserId) {
        if(Strings.isNullOrBlank(portfolioUserId)) {
            throw new InvalidInputException("Cannot delete an empty portfolioUserId");
        }

        this.repository.deleteById(portfolioUserId).log().block();
    }
}
