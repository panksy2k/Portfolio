package com.financial.ledger.microservices.core.user.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PortfolioUsersRepository extends ReactiveCrudRepository<PortfolioUserEntity, String> {
    Mono<PortfolioUserEntity> findByUserName(String userName);
}
