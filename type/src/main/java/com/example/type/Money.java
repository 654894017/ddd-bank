package com.example.type;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amout;

    private Currency currency;

    @JsonCreator
    public Money(@JsonProperty("amout") BigDecimal amout, @JsonProperty("currency") Currency currency) {

        if (amout == null) {
            throw new IllegalArgumentException("金额不能为空");
        }
        this.amout = amout;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmout() {
        return amout;
    }

    public int compareTo(Money money) {
        return this.amout.compareTo(money.getAmout());
    }

    public Money subtract(Money money) {
        BigDecimal resultAmout = this.amout.subtract(money.getAmout());
        return new Money(resultAmout, this.currency);
    }


    public Money add(Money money) {
        BigDecimal resultAmout = this.amout.add(money.getAmout());
        return new Money(resultAmout, this.currency);
    }
}
