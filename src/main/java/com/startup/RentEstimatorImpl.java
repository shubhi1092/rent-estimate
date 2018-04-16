package com.startup;

import com.startup.common.RentRange;
import com.startup.gateways.ZillowImpl;
import org.springframework.lang.NonNull;

public class RentEstimatorImpl implements RentEstimator {
    @Override
    public RentRange estimate(@NonNull String address) {
        ZillowImpl zapi = new ZillowImpl();
        RentRange rentRange = zapi.fetchRentEstimate(address);

        return rentRange;
    }
}
