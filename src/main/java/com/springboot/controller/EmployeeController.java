package com.springboot.controller;

import com.springboot.dto.EmployeeDto;
import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/v1/api")
@RestController
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Page<Employee> getAllEmployees(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "limit", defaultValue = "5") int limit) {
        return employeeService.getAllEmployees(page, limit);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee e = employeeService.getEmployeeById(id);
        if (e == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid EmployeeDto employee) {
        return employeeService.saveOrUpdate(employee);
    }

}
