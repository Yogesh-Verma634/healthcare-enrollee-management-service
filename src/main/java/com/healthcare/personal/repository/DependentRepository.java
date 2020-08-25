package com.healthcare.personal.repository;

import com.healthcare.personal.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {
}
