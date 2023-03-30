package com.damjanh.climbtracker.service;

import com.damjanh.climbtracker.entity.Route;
import com.damjanh.climbtracker.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutesService implements IRoutesService {

    @Autowired
    private RoutesRepository repository;

    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Route> getAttemptsForUser(long userId) {
        return repository.findByAttempts_UserId(userId);
    }
}
