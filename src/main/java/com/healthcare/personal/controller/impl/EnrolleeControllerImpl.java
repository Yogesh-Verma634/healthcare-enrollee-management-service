package com.healthcare.personal.controller.impl;

import com.healthcare.personal.controller.EnrolleeController;
import com.healthcare.personal.model.Enrollee;
import com.healthcare.personal.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
public class EnrolleeControllerImpl implements EnrolleeController {

    @Autowired
    EnrolleeRepository enrolleeRepository;

    @Override
    public ResponseEntity<Enrollee> getEnrolleeDetails(Integer enrolleeId) throws HttpClientErrorException.BadRequest {
        return enrolleeRepository.findById(enrolleeId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> create(Enrollee enrollee) throws HttpClientErrorException.BadRequest {
        enrolleeRepository.save(enrollee);
        return ResponseEntity.ok("Successfully saved the enrollee record");
    }

    @Override
    public ResponseEntity<String> update(Enrollee enrollee) throws HttpClientErrorException.BadRequest {
        Optional<Enrollee> enrolleeOptional = enrolleeRepository.findById(enrollee.id);

        if(enrolleeOptional.isPresent()){
            enrolleeRepository.save(enrollee);
            return ResponseEntity.ok("Successfully updated the enrollee record");
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(Integer enrolleeId) throws HttpClientErrorException.BadRequest {
        Optional<Enrollee> enrollee = enrolleeRepository.findById(enrolleeId);

        if(enrollee.isPresent()){
            enrolleeRepository.deleteById(enrolleeId);
            return ResponseEntity.ok("Successfully deleted enrollee record");
        }
        return ResponseEntity.notFound().build();
    }
}
