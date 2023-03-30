package com.damjanh.climbtracker.service;

import com.damjanh.climbtracker.entity.Attempt;
import com.damjanh.climbtracker.entity.AttemptType;
import com.damjanh.climbtracker.entity.Route;
import com.damjanh.climbtracker.repository.AttemptsRepository;
import com.damjanh.climbtracker.repository.RoutesRepository;
import com.damjanh.climbtracker.security.model.User;
import com.damjanh.climbtracker.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptsService implements IAttemptsService {

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private AttemptsRepository attemptsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Route createAttempt(long userId, long routeId, AttemptType attemptType) {
        if (!userRepository.existsById(userId)) {
            return null;
        } else if (!routesRepository.existsById(routeId)) {
            return null;
        }
        User user = userRepository.getById(userId);
        Route route = routesRepository.getById(routeId);
        attemptsRepository.save(new Attempt(user, route, attemptType));
        return route;
    }
}
