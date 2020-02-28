package com.sandbox.microservices.currency.exchange.controllers;

import com.sandbox.microservices.currency.exchange.dao.ExchangeValueRepository;
import com.sandbox.microservices.currency.exchange.models.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class ExchangeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port:0}")
    private Integer port;
    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        logger.trace("Get exchange from {} to {}", from, to);
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(port);
        return exchangeValue;
    }
}
