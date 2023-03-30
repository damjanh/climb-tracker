package com.damjanh.climbtracker.controller;

import com.damjanh.climbtracker.controller.request.CreateAttemptRequest;
import com.damjanh.climbtracker.entity.AttemptType;
import com.damjanh.climbtracker.entity.Route;
import com.damjanh.climbtracker.security.payload.response.MessageResponse;
import com.damjanh.climbtracker.service.IAttemptsService;
import com.damjanh.climbtracker.service.IRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AttemptsController {

    @Autowired
    private IAttemptsService attemptsService;

    @Autowired
    private IRoutesService routesService;

    @RequestMapping(value = "/attempts/{userId}")
    public ResponseEntity<List<Route>> getAttemptsForUser(@PathVariable("userId") long id) {
        List<Route> routesAttemptedByUser = routesService.getAttemptsForUser(id);

        return new ResponseEntity<>(routesAttemptedByUser, HttpStatus.OK);
    }

    @PostMapping(value = "/attempts")
    public ResponseEntity<?> createAttempt(@RequestBody CreateAttemptRequest request) {

        AttemptType e = AttemptType.valueOf(request.getAttemptType());

        Route attemptedRoute = attemptsService.createAttempt(request.getUserId(), request.getRouteId(), e);
        if (attemptedRoute == null) {
            return new ResponseEntity<>(new MessageResponse("Error!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attemptedRoute, HttpStatus.CREATED);
    }
}
