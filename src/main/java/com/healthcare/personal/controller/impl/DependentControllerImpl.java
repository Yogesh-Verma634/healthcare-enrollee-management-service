package com.healthcare.personal.controller.impl;

import com.healthcare.personal.controller.DependentController;
import com.healthcare.personal.model.Dependent;
import com.healthcare.personal.repository.DependentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
public class DependentControllerImpl implements DependentController {

    private static final Logger logger = LoggerFactory.getLogger(DependentController.class);

    @Autowired
    public DependentRepository dependentRepository;

    @Override
    public ResponseEntity<Dependent> getDependentDetails(Integer dependentId) throws HttpClientErrorException.BadRequest {
        logger.info("Getting enrollee details for id: {}", dependentId);

        Optional<Dependent> dependent =  dependentRepository.findById(dependentId);

        if(dependent.isPresent()){
            return ResponseEntity.ok(dependent.get());
        }
        logger.info("Dependent details not found.");
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> add(Dependent dependent) throws HttpClientErrorException.BadRequest {
        logger.info("Adding a dependent to an enrollee id: {}", dependent.enrollee);
        dependentRepository.save(dependent);
        return ResponseEntity.ok("Successfully saved the dependent for an enrollee");
    }

    @Override
    public ResponseEntity<String> modify(Dependent dependent) throws HttpClientErrorException.BadRequest {
        logger.info("Updating dependent record to an enrollee id: {}", dependent.enrollee);
        Optional<Dependent> dependentOptional = dependentRepository.findById(dependent.id);

        if(dependentOptional.isPresent()){
            dependentRepository.save(dependent);
            return ResponseEntity.ok("Successfully updated the dependent for an enrollee");
        }

        logger.info("Dependent not found. Create a new record");
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(Integer dependentId) throws HttpClientErrorException.BadRequest {
        logger.info("Deleting dependent record with id: {}", dependentId);

        Optional<Dependent> dependent = dependentRepository.findById(dependentId);

        if(dependent.isPresent()){
            dependentRepository.deleteById(dependentId);
            return ResponseEntity.ok("Successfully deleted the dependent for an enrollee");
        }

        logger.info("Dependent not found.");
        return ResponseEntity.notFound().build();
    }
}
