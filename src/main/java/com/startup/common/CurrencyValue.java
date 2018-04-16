package com.startup.common;

import java.util.Currency;

public class CurrencyValue {
    private final Currency currency;
    private final int value;

    public CurrencyValue(Currency currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }
}
