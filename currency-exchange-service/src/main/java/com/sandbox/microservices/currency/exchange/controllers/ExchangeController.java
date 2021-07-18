package com.sandbox.microservices.currency.exchange.controllers;

import com.sandbox.microservices.currency.exchange.dao.ExchangeValueRepository;
import com.sandbox.microservices.currency.exchange.models.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class ExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeController.class);

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        logger.trace("Get exchange from {} to {}", from, to);
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setHostname(getHostname());
        return exchangeValue;
    }

    private static String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.trace("Get hostname Exception: ", e);
            return null;
        }
    }
}
