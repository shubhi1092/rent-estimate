package com.startup.common;

import java.math.BigInteger;
import java.util.Currency;

public class CurrencyValue {
    private final Currency currency;
    private final BigInteger value;

    public CurrencyValue(Currency currency, BigInteger value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigInteger getValue() {
        return value;
    }
}
