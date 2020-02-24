package com.sandbox.microservices.currency.conversion.feign;

import com.sandbox.microservices.currency.conversion.models.ConversionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Andrii Sysoiev
 */
@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000/")
public interface CurrencyExchangeClient {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ConversionResult retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
