package com.sandbox.microservices.currency.conversion.configs;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static brave.sampler.Sampler.ALWAYS_SAMPLE;

/**
 * @author Andrii Sysoiev
 */
@Configuration
public class DistributedTracingConfig {

    @Bean
    public Sampler defaultSampler() {
        return ALWAYS_SAMPLE;
    }

}
