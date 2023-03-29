package com.damjanh.climbtracker.controller;

import com.damjanh.climbtracker.entity.Dificulty;
import com.damjanh.climbtracker.entity.Route;
import com.damjanh.climbtracker.service.IRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RoutesController {

    @Autowired
    private IRoutesService routesService;

    @RequestMapping(value = "/routes")
    public ResponseEntity<List<Route>> getRoutes() {
        List<Route> routes = new ArrayList<>();
//        routes.add(new Route("Lepotička", "Sektor: Pisani Svet", 30, Dificulty.DIF_6a));
//        routes.add(new Route("Frančkova smer", "Sektor: Pisani Svet", 30, Dificulty.DIF_5b));

        routes = routesService.findAll();

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
}
