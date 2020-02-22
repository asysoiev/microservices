package com.sandbox.microservices.exchange.dao;

import com.sandbox.microservices.exchange.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrii Sysoiev
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);

}
