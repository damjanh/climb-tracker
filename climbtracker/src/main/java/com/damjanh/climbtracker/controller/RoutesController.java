package com.damjanh.climbtracker.controller;

import com.damjanh.climbtracker.model.Dificulty;
import com.damjanh.climbtracker.model.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoutesController {

    @RequestMapping(value = "/routes")
    public ResponseEntity<List<Route>> getRoutes() {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route("Lepotička", "Sektor: Pisani Svet", 30, Dificulty.DIF_6a));
        routes.add(new Route("Frančkova smer", "Sektor: Pisani Svet", 30, Dificulty.DIF_5b));

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
}
