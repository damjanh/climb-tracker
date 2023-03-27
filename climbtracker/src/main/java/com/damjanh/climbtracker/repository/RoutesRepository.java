package com.damjanh.climbtracker.repository;

import com.damjanh.climbtracker.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Long> {
}
