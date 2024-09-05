package com.week2.week2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.week2.week2.dtos.EmployeeDTO;
import com.week2.week2.exceptions.ResourceNotFoundException;
import com.week2.week2.services.EmployeeService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);
        return employeeDTO.map(employee -> ResponseEntity.ok(employee))
                .orElseThrow(() -> new ResourceNotFoundException("No Employee found with id " + employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO entity) {
        return new ResponseEntity<>(employeeService.createNewEmployee(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable(name = "employeeId") Long employeeId,
            @RequestBody @Valid EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.updateEmployeeById(employeeId, employeeDTO), HttpStatus.OK);
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable Long employeeId,
            @RequestBody Map<String, Object> update) {
        return new ResponseEntity<>(employeeService.updatePartialEmployeeById(employeeId, update), HttpStatus.OK);

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> deleteEmployeeById(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(employeeId), HttpStatus.OK);
    }

}
