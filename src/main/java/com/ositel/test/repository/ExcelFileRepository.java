package com.ositel.test.repository;

/**
 * Created by DEFARTECH on 22/09/2018.
 */

import com.ositel.test.entity.ExelFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by DEFARTECH on 22/09/2018.
 */

public interface ExcelFileRepository extends CrudRepository<ExelFile, Long> {

    // un exelfile avec Employee
    @Query("select e from ExelFile  e join fetch e.employees em where e.id=?1")
    public ExelFile getExelFileIdenti(Long id);

    @Query("select e from ExelFile e left join fetch e.employees em where e.name=?1")
    public ExelFile getExelFilenom(String nom);

    // un exelfile avec Employee désigné par son nom

    public  ExelFile findByName(String nom);


}
