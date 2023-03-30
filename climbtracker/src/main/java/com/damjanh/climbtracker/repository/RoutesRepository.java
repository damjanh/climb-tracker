package com.damjanh.climbtracker.repository;

import com.damjanh.climbtracker.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Long> {

    List<Route> findByAttempts_UserId(long userId);
}
