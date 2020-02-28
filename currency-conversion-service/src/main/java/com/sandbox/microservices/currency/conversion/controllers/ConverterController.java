package com.sandbox.microservices.currency.conversion.controllers;

import com.sandbox.microservices.currency.conversion.feign.CurrencyExchangeClient;
import com.sandbox.microservices.currency.conversion.models.ConversionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class ConverterController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeClient currencyExchangeClient;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionResult convertCurrency(@PathVariable String from, @PathVariable String to,
                                            @PathVariable BigDecimal quantity) {
        logger.trace("Convert {} from {} to {}", quantity, from, to);

        ConversionResult exchangeResponse = currencyExchangeClient.retrieveExchangeValue(from, to);

        ConversionResult convertResult = exchangeResponse.clone();
        convertResult.setQuantity(quantity);
        convertResult.convert();

        return convertResult;
    }
}
