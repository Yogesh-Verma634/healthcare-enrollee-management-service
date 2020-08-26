package com.healthcare.personal.controller;

import com.healthcare.personal.model.Dependent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RequestMapping("/dependent")
@Api(produces = "application/json", tags = {"Dependent Controller"})
public interface DependentController {

    @GetMapping("/{dependent_id}")
    @ApiOperation(value = "Retrieve dependent information")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved  dependent information", response = Dependent.class)
    }
    )
    ResponseEntity<Dependent> getDependentDetails(@PathVariable Integer dependentId) throws HttpClientErrorException.BadRequest;

    @PostMapping("/")
    @ApiOperation(value = "Add a dependent to an enrollee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added a dependent to an enrollee", response = Dependent.class)
    }
    )
    ResponseEntity<String> add(@RequestBody Dependent dependent) throws HttpClientErrorException.BadRequest;

    @PutMapping("/")
    @ApiOperation(value = "Modify a dependent to an enrollee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully modify dependent to an enrollee", response = void.class)
    }
    )
    ResponseEntity<String> modify(@RequestBody Dependent dependent) throws HttpClientErrorException.BadRequest;

    @DeleteMapping("/{dependent_id}")
    @ApiOperation(value = "Delete a dependent to an enrollee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted dependent to an enrollee", response = void.class)
    }
    )
    ResponseEntity<String> delete(@PathVariable Integer dependentId) throws HttpClientErrorException.BadRequest;

}
