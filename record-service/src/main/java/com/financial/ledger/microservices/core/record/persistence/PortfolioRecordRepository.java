package com.financial.ledger.microservices.core.record.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PortfolioRecordRepository extends ReactiveCrudRepository<PortfolioRecordEntity, String> {
}
