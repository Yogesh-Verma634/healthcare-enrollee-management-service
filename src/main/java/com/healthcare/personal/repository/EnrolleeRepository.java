package com.healthcare.personal.repository;

import com.healthcare.personal.model.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer> {
}
