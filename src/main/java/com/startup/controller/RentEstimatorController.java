package com.startup.controller;

import com.google.gson.JsonObject;
import com.startup.common.EmailValidatorImpl;
import com.startup.common.PhoneValidatorImpl;
import com.startup.common.Validator;
import com.startup.service.RentEstimator;
import com.startup.service.RentEstimatorImpl;
import com.startup.model.RentRange;
import com.startup.model.User;
import com.startup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;
import com.startup.gateways.Sendgrid;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@EnableAutoConfiguration
public class RentEstimatorController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder builder, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();

        Validator validator = new EmailValidatorImpl();
        boolean isValid = validator.validate(user.getEmailAddress());
        JsonObject jsonObject = new JsonObject();
        if(!isValid) {
            jsonObject.addProperty("message", "Error");
            return new ResponseEntity<String>(jsonObject.toString(), headers, HttpStatus.BAD_REQUEST);
        }

        validator = new PhoneValidatorImpl();
        isValid = validator.validate(user.getPhoneNumber());
        if(!isValid) {
            jsonObject.addProperty("message", "Error");
            return new ResponseEntity<String>(jsonObject.toString(), headers, HttpStatus.BAD_REQUEST);
        }

        user.setIpAddress(request.getRemoteAddr());
        long id = userService.saveUser(user);
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(id).toUri());

        jsonObject.addProperty("message", "Success");
        return new ResponseEntity<String>(jsonObject.toString(), headers, HttpStatus.CREATED);
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

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", "Success");
        jsonObject.addProperty("estimatedRent", existingUser.getEstimatedRent().toString());
        return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
    }
}