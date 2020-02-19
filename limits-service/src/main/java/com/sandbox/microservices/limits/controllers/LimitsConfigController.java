package com.sandbox.microservices.limits.controllers;

import com.sandbox.microservices.limits.models.LimitsConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class LimitsConfigController {

    @GetMapping("/limits")
    public LimitsConfig getLimitsConfig() {
        return new LimitsConfig(1, 1000);
    }
}
