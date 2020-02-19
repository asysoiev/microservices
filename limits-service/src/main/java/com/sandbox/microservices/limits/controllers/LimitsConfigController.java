package com.sandbox.microservices.limits.controllers;

import com.sandbox.microservices.limits.configs.PropertiesConfiguration;
import com.sandbox.microservices.limits.models.LimitsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class LimitsConfigController {

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @GetMapping("/limits")
    public LimitsConfig getLimitsConfig() {
        return new LimitsConfig(propertiesConfiguration.getMin(), propertiesConfiguration.getMax());
    }
}
