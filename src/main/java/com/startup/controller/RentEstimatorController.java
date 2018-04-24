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
import com.startup.gateways.Sendgrid;

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
        User existingUser = userService.getUser(id);
        if(user.getAddress() != null) {
            existingUser.setAddress(user.getAddress());
            userService.updateUser(existingUser);
            RentEstimator estimator = new RentEstimatorImpl();
            RentRange range = estimator.estimate(user.getAddress());
            existingUser.setEstimatedRent(range);
            userService.updateUser(existingUser);
        }

        if(user.getExpectedRent() != null) {
            existingUser.setExpectedRent(user.getExpectedRent());
            userService.updateUser(existingUser);
        }

        // Send updates to user
        Sendgrid.sendEmail(existingUser);
        return new ResponseEntity<String>("Successfully submitted!", HttpStatus.OK);
    }
}