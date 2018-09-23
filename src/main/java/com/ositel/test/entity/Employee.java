package com.ositel.test.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
/**
 * Created by DEFARTECH on 22/09/2018.
 */
@Entity
public class Employee {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EXCEL_ID", insertable = false, updatable = false)
    private Long ideXEL;

    private String employeeId;
    // un Employe  est lié à un ExelFile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXCEL_ID")
    private ExelFile exfile;


    private String employeeName;
    private String address;
    private String country;

    public Employee(String address, String country, String employeeId,
            String employeeName) {
        this.address = address;
        this.country = country;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public ExelFile getExelFile() {
        return exfile;
    }

    public void setExelFile(ExelFile ex) {
        this.exfile = ex;
    }


    public Employee() {
    }

    public String getEmployeeId() {

        return employeeId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdeXEL() {
        return ideXEL;
    }

    public void setIdeXEL(Long ideXEL) {
        this.ideXEL = ideXEL;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
