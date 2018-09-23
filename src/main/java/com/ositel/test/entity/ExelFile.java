package com.ositel.test.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DEFARTECH on 23/09/2018.
 */
@Entity
public class ExelFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="Name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exfile", cascade = { CascadeType.ALL })
    public Set<Employee> employees = new HashSet<Employee>();

    public ExelFile() {
    }



    public ExelFile(Long id) {

        this.id=id;

    }


    public Set<Employee> addEmployee(Employee emp) {

                 employees.add(emp);

                emp.setExelFile(this);

        return  employees;

             }

    public void setEmployees(Set<Employee> emp) {
        this.employees = emp;
    }


    public ExelFile(Long id, String name){

        this.id=id;
        this.name=name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Employee> getEmployees() {
        return employees;
    }



    public ExelFile(Set<Employee> employees, String nam) {
        this.employees = employees;
        this.name = name;

    }

    public ExelFile(Set<Employee> employees, String nam,Long id) {
        this.employees = employees;
        this.id = id;
        this.name = nam;

    }
    // to String
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }






}
