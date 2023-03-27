package com.damjanh.climbtracker.service;

import com.damjanh.climbtracker.entity.Route;

import java.util.List;

public interface IRoutesService {
    List<Route> findAll();
}
