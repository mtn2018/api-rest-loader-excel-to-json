package com.ositel.test.rest;


import com.ositel.test.entity.Employee;
import com.ositel.test.entity.ExelFile;
import com.ositel.test.repository.EmployeeRepository;
import com.ositel.test.repository.ExcelFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DEFARTECH on 22/09/2018.
 */
@RestController
@RequestMapping(ResourceConstants.COMMON_ENDPOINT_API)
public class EmployeeController {

   @Autowired
   EmployeeRepository employeeRepository;

    @Autowired
    ExcelFileRepository exelFileRepositoryRepository;

    ExelFile tr;



   @RequestMapping(path = "/addExcelFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   public void addExcelFileMethod(
           @PathVariable String name
           ) {

           tr.setName(name);

           exelFileRepositoryRepository.save(tr);
   }


    @RequestMapping(value="/searchExcelFile/{name}", method = RequestMethod.GET)
    public @ResponseBody
    ExelFile searchExelFileByname(@PathVariable String name){

        ExelFile a = exelFileRepositoryRepository.findByName(name);

        return a;

    }

    @RequestMapping(value="/allEmployees", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Employee> getProducts() {
        return  employeeRepository.findAll();
    }

    @RequestMapping(value="/allExelFilename", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<ExelFile> getAllFileNames() {
        return exelFileRepositoryRepository.findAll();
    }








}
