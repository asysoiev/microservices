package com.sandbox.microservices.currency.conversion.controllers;

import com.sandbox.microservices.currency.conversion.models.ConversionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class ConverterController {

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionResult convertCurrency(@PathVariable String from, @PathVariable String to,
                                            @PathVariable BigDecimal quantity) {

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("from", from);
        uriParams.put("to", to);
        ResponseEntity<ConversionResult> exchangeRespEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                ConversionResult.class,
                uriParams);

        ConversionResult exchangeResponse = exchangeRespEntity.getBody();

        ConversionResult convertResult = exchangeResponse.clone();
        convertResult.setQuantity(quantity);
        convertResult.convert();

        return convertResult;
    }
}
