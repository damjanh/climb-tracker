package com.damjanh.climbtracker.service;

import com.damjanh.climbtracker.entity.AttemptType;
import com.damjanh.climbtracker.entity.Route;

public interface IAttemptsService {

    Route createAttempt(long userId, long routeId, AttemptType attemptType);

}
