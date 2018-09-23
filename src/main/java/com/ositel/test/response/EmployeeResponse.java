package com.ositel.test.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ositel.test.entity.Employee;
import com.ositel.test.entity.ExelFile;

/**
 * Created by DEFARTECH on 22/09/2018.
 */
public class EmployeeResponse {

    Employee empresp;

    ExelFile exelValue;

    public EmployeeResponse(ExelFile exelValue,Employee empresp) {
        this.empresp = empresp;
        this.exelValue = exelValue;
    }

    public EmployeeResponse(Iterable<ExelFile> all) {
    }



    public Employee getEmpresp() {
        return empresp;
    }

    public void setEmpresp(Employee empresp) {
        this.empresp = empresp;
    }

    public ExelFile getExelValue() {
        return exelValue;
    }

    public void setExelValue(ExelFile exelValue) {
        this.exelValue = exelValue;
    }



    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }



}
