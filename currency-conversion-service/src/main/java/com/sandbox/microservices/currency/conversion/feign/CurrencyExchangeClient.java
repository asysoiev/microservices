package com.sandbox.microservices.currency.conversion.feign;

import com.sandbox.microservices.currency.conversion.models.ConversionResult;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Andrii Sysoiev
 */
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeClient {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ConversionResult retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
