package com.sandbox.microservices.exchange.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * @author Andrii Sysoiev
 */
@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue(generator = "exchange_value_seq")
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal rate;
    @Transient
    private int port;

    public Long getId() {
        return id;
    }

    public ExchangeValue setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public ExchangeValue setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public ExchangeValue setTo(String to) {
        this.to = to;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public ExchangeValue setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public int getPort() {
        return port;
    }

    public ExchangeValue setPort(int port) {
        this.port = port;
        return this;
    }
}
