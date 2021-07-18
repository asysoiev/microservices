package com.sandbox.microservices.currency.conversion.models;

import java.math.BigDecimal;

/**
 * @author Andrii Sysoiev
 */
public class ConversionResult implements Cloneable {

    private Long id;
    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal quantity;
    private BigDecimal convertedAmount;
    private String hostname;

    public ConversionResult() {
        rate = BigDecimal.ZERO;
        quantity = BigDecimal.ZERO;
        convertedAmount = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }

    public ConversionResult setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public ConversionResult setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public ConversionResult setTo(String to) {
        this.to = to;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public ConversionResult setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public ConversionResult setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public ConversionResult setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
        return this;
    }

    public String getHostname() {
        return hostname;
    }

    public ConversionResult setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    @Override
    public ConversionResult clone() {
        try {
            return (ConversionResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void convert() {
        convertedAmount = quantity.multiply(rate);
    }
}
