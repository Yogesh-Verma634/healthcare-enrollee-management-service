package com.healthcare.personal.controller.impl;

import com.healthcare.personal.controller.EnrolleeController;
import com.healthcare.personal.model.Enrollee;
import com.healthcare.personal.repository.DependentRepository;
import com.healthcare.personal.repository.EnrolleeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
public class EnrolleeControllerImpl implements EnrolleeController {

    private static final Logger logger = LoggerFactory.getLogger(EnrolleeController.class);

    @Autowired
    EnrolleeRepository enrolleeRepository;

    @Autowired
    DependentRepository dependentRepository;

    @Override
    public ResponseEntity<Enrollee> getEnrolleeDetails(Integer enrolleeId) throws HttpClientErrorException.BadRequest {
        logger.info("Getting enrollee details for enrollee id: {}", enrolleeId);
        Optional<Enrollee> enrollee = enrolleeRepository.findById(enrolleeId);

        if(enrollee.isPresent()) {
            return ResponseEntity.ok(enrollee.get());
        }

        logger.info("Enrollee record not found");
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> create(Enrollee enrollee) throws HttpClientErrorException.BadRequest {
        logger.info("Creating an enrollee record for enrollee: {}", enrollee.name);
        enrolleeRepository.save(enrollee);
        return ResponseEntity.ok("Successfully saved the enrollee record");
    }

    @Override
    public ResponseEntity<String> update(Enrollee enrollee) throws HttpClientErrorException.BadRequest {
        logger.info("Updating the enrollee record for enrollee id and name: {}. {}", enrollee.id, enrollee.name);
        Optional<Enrollee> enrolleeOptional = enrolleeRepository.findById(enrollee.id);

        if(enrolleeOptional.isPresent()){
            enrolleeRepository.save(enrollee);
            return ResponseEntity.ok("Successfully updated the enrollee record");
        }
        logger.info("Enrollee record not found. Create a new record");
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(Integer enrolleeId) throws HttpClientErrorException.BadRequest {
        Optional<Enrollee> enrollee = enrolleeRepository.findById(enrolleeId);

        if(enrollee.isPresent()){
            dependentRepository.deleteByEnrollee(enrolleeId);
            logger.info("Deleted dependents for the enrollee");
            enrolleeRepository.deleteById(enrolleeId);
            return ResponseEntity.ok("Successfully deleted enrollee record");
        }
        logger.info("Enrollee record not found");
        return ResponseEntity.notFound().build();
    }
}
