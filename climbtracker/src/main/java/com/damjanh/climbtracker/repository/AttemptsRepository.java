package com.damjanh.climbtracker.repository;

import com.damjanh.climbtracker.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttemptsRepository extends JpaRepository<Attempt, Long> {
}
