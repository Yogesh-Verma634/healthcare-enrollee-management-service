package com.healthcare.personal.controller.impl;

import com.healthcare.personal.controller.DependentController;
import com.healthcare.personal.model.Dependent;
import com.healthcare.personal.repository.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

public class DependentControllerImpl implements DependentController {

    @Autowired
    public DependentRepository dependentRepository;

    @Override
    public ResponseEntity<Dependent> getDependentDetails(Integer dependentId) throws HttpClientErrorException.BadRequest {
        return dependentRepository.findById(dependentId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> add(Dependent dependent) throws HttpClientErrorException.BadRequest {
        dependentRepository.save(dependent);
        return ResponseEntity.ok("Successfully saved the dependent for an enrollee");
    }

    @Override
    public ResponseEntity<String> modify(Dependent dependent) throws HttpClientErrorException.BadRequest {
        Optional<Dependent> dependentOptional = dependentRepository.findById(dependent.id);

        if(dependentOptional.isPresent()){
            dependentRepository.save(dependent);
            return ResponseEntity.ok("Successfully updated the dependent for an enrollee");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(Integer dependentId) throws HttpClientErrorException.BadRequest {
        Optional<Dependent> dependentOptional = dependentRepository.findById(dependentId);

        if(dependentOptional.isPresent()){
            dependentRepository.deleteById(dependentId);
            return ResponseEntity.ok("Successfully deleted the dependent for an enrollee");
        }
        return ResponseEntity.notFound().build();
    }
}
