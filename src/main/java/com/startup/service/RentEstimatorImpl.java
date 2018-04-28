package com.startup.service;

import com.startup.model.RentRange;
import com.startup.gateways.ZillowImpl;
import org.springframework.lang.NonNull;

public class RentEstimatorImpl implements RentEstimator {
    @Override
    public RentRange estimate(@NonNull String address, @NonNull int zipcode) throws Exception {
        ZillowImpl zapi = new ZillowImpl();
        RentRange rentRange = zapi.fetchRentEstimate(address, zipcode);

        return rentRange;
    }
}
