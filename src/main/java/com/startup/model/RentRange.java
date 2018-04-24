package com.startup.model;

import com.startup.common.CurrencyValue;

import java.util.Currency;

/**
 * Internal representation of rent range bounds
 * Serves as a model class as well
 */
public class RentRange {
    private final Currency currency;
    private final int lowerBound;
    private final int upperBound;

    public RentRange(Currency currency, int lowerBound, int upperBound) {
        this.currency = currency;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    @Override
    public String toString() {
        if (this == null) {
            return null;
        } else {
            String range = String.format("(%d - %d) %s", lowerBound, upperBound, currency.toString());
            return range;
        }
    }
}
