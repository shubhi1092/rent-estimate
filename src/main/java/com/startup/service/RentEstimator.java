package com.startup.service;

import com.startup.model.RentRange;
import org.springframework.lang.NonNull;

public interface RentEstimator {
    RentRange estimate(@NonNull String address, @NonNull int zipcode);
}
