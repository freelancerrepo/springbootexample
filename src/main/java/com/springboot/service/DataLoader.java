package com.springboot.service;

import com.springboot.dao.DepartmentRepository;
import com.springboot.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DataLoader(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void run(ApplicationArguments args) {
        departmentRepository.save(new Department(1, "HR", "HR department", null));
        departmentRepository.save(new Department(2, "APPS", "APPS department", null));
        departmentRepository.save(new Department(3, "SECURITY", "Security department", null));
    }

}