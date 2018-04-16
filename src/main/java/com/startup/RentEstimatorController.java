package com.startup;

import com.startup.common.RentRange;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class RentEstimatorController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String estimate(@RequestBody String address) {
        RentEstimator estimator = new RentEstimatorImpl();
        RentRange range = estimator.estimate(address);
        return range.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RentEstimatorController.class, args);
    }
}