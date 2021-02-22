package com.springboot.service;

import com.springboot.dao.DepartmentRepository;
import com.springboot.dao.EmployeeRepository;
import com.springboot.dto.EmployeeDto;
import com.springboot.model.Department;
import com.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public static final String MESSAGE = "Given Department Id doesn't exist";

    public Page<Employee> getAllEmployees(int page, int limit) {
        Pageable paging = PageRequest.of(page, limit);
        return employeeRepository.findAll(paging);
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) return emp.get();
        else return null;
    }

    public ResponseEntity<String> saveOrUpdate(EmployeeDto employee) {
        Employee e = new Employee();
        e.setCity(employee.getCity());
        e.setFirstname(employee.getFirstname());
        e.setLastname(employee.getLastname());
        Optional<Department> department = departmentRepository.findById(employee.getDepartment_id());
        if (department.isPresent())
            e.setDepartment(department.get());
        else
            return new ResponseEntity<>(MESSAGE, HttpStatus.NOT_FOUND);
        employeeRepository.save(e);
        return new ResponseEntity<>(HttpStatus.OK.name(), HttpStatus.OK);
    }

    public void delete(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent())
            employeeRepository.deleteById(id);
    }

}