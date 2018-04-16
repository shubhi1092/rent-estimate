package com.startup.controller;

import com.startup.service.RentEstimator;
import com.startup.service.RentEstimatorImpl;
import com.startup.model.RentRange;
import com.startup.model.User;
import com.startup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/")
public class RentEstimatorController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder builder) {
        RentEstimator estimator = new RentEstimatorImpl();
        RentRange range = estimator.estimate(user.getAddress());
        user.setEstimatedRent(range);
        userService.saveUser(user);
        return new ResponseEntity<RentRange>(range, HttpStatus.OK);
    }
}