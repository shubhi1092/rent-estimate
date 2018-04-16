package com.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.startup"})
public class RentEstimatorApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RentEstimatorApp.class, args);
    }
}
