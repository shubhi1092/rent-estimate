package com.startup.controller;

import com.startup.common.EmailValidatorImpl;
import com.startup.common.PhoneValidatorImpl;
import com.startup.common.Validator;
import com.startup.service.RentEstimator;
import com.startup.service.RentEstimatorImpl;
import com.startup.model.RentRange;
import com.startup.model.User;
import com.startup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
        HttpHeaders headers = new HttpHeaders();
        Validator validator = new EmailValidatorImpl();
        boolean isValid = validator.validate(user.getEmailAddress());
        if(!isValid) {
            return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
        }

        validator = new PhoneValidatorImpl();
        isValid = validator.validate(user.getPhoneNumber());
        if(!isValid) {
            return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
        }

        long id = userService.saveUser(user);
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(id).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        RentEstimator estimator = new RentEstimatorImpl();
        User currentUser = userService.getUser(id);
        currentUser.setAddress(user.getAddress());

        RentRange range = estimator.estimate(currentUser.getAddress());
        currentUser.setEstimatedRent(range);
        currentUser.setExpectedRent(user.getExpectedRent());

        userService.updateUser(currentUser);
        return new ResponseEntity<RentRange>(currentUser.getEstimatedRent(), HttpStatus.OK);
    }
}