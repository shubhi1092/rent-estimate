package com.startup;

import com.startup.common.RentRange;
import org.springframework.lang.NonNull;

public interface RentEstimator {
    RentRange estimate(@NonNull String address);
}
