package com.sandbox.microservices.limits.models;

/**
 * @author Andrii Sysoiev
 */
public class LimitsConfig {
    private final int min;
    private final int max;

    public LimitsConfig(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
