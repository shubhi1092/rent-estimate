package com.startup.common;

/**
 * Internal representation of rent range bounds
 * Serves as a model class as well
 */
public class RentRange {
    private final CurrencyValue lowerBound;
    private final CurrencyValue upperBound;

    public RentRange(CurrencyValue lowerBound, CurrencyValue upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public CurrencyValue getLowerBound() {
        return lowerBound;
    }

    public CurrencyValue getUpperBound() {
        return upperBound;
    }

    @Override
    public String toString() {
        return String.format("Range ranges from %s to %s %s", lowerBound.getValue(), upperBound.getValue(), upperBound.getCurrency());
    }
}
