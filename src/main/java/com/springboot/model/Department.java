package com.springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Department implements Serializable{

    @Id
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "description")
    private String departmentDescription;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

}
