package com.damjanh.climbtracker.messaging;

import com.damjanh.climbtracker.entity.Dificulty;
import com.damjanh.climbtracker.entity.Route;
import com.damjanh.climbtracker.repository.RoutesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RouteReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteReceiver.class);

    @Autowired
    private RoutesRepository repository;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info("Received message -> {}", message);

        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String,Object> result = mapper.readValue(message, HashMap.class);
            Route route = mapToRoute(result);
            repository.save(route);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private Route mapToRoute(Map<String,Object> map) {
        Route route = new Route();
        route.setTitle((String) map.get("title"));
        route.setDescription((String) map.get("description"));
        route.setLengthMeters((Integer) map.get("lengthMeters"));
        route.setDificulty(Dificulty.valueOf((String) map.get("dificulty")));
        return route;
    }
}
