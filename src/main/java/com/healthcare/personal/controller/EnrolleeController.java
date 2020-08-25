package com.healthcare.personal.controller;

import com.healthcare.personal.model.Enrollee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RequestMapping("/enrollee")
@Api(produces = "application/json", tags = {"Enrollee Controller"})
public interface EnrolleeController {

    @GetMapping("/")
    @ApiOperation(value = "Retrieve enrollee information")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved  enrollee information", response = Enrollee.class)
    }
    )
    ResponseEntity<Enrollee> getEnrolleeDetails() throws HttpClientErrorException.BadRequest;

    @PostMapping("/")
    @ApiOperation(value = "Create enrollee record")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created enrollee record", response = Enrollee.class)
    }
    )
    ResponseEntity<String> create(@RequestBody Enrollee enrollee) throws HttpClientErrorException.BadRequest;

    @PutMapping("/")
    @ApiOperation(value = "Update enrollee record")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated enrollee record", response = void.class)
    }
    )
    ResponseEntity<String> update(@RequestBody Enrollee enrollee) throws HttpClientErrorException.BadRequest;

    @DeleteMapping("/{enrollee_id}")
    @ApiOperation(value = "Delete the enrollee record")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the enrollee record", response = void.class)
    }
    )
    ResponseEntity<String> delete(@PathVariable Integer enrolleeId) throws HttpClientErrorException.BadRequest;
}
