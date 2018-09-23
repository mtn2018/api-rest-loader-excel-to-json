package com.ositel.test.repository;

/**
 * Created by DEFARTECH on 22/09/2018.
 */

import com.ositel.test.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by DEFARTECH on 22/09/2018.
 */

public interface  EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select p from Employee p left join fetch p.exfile c where p.id=?1")
    public Employee getEmployeeiden(Long id);

    @Query("select p from Employee p left join fetch p.exfile c where p.id=?1")
    public Employee getEmployeeNom(String n);


   // public Employee findByEmployeeName(String nom);


}
