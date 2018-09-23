package com.ositel.test.rest;

/**
 * Created by DEFARTECH on 22/09/2018.
 */
import com.ositel.test.entity.Employee;
import com.ositel.test.entity.ExelFile;
import com.ositel.test.repository.EmployeeRepository;
import com.ositel.test.repository.ExcelFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(ResourceConstants.COMMON_ENDPOINT_API)
public class FileUploadController {

	@Autowired
	FileUploadService uploadService;

    @Autowired
    ExcelFileRepository excelFileRepository;

    @Autowired
    EmployeeRepository employeeRepository;



	@RequestMapping(path = "/uploadfilexls/{idExcelFile}", method = RequestMethod.POST)
    public void singleFileUpload(
            @PathVariable Long idExcelFile,
            @RequestParam("file") MultipartFile file             ) {

        if (file.isEmpty()) {
           System.out.print(("message"+ "Please select a file to upload"));

        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();



            // Create a file name temp in C path =C:/temp
            Path path = Paths.get("C://temp//" + file.getOriginalFilename());
            Files.write(path, bytes);

            uploadService.uploadFileData("C://temp//" + path.getFileName());

            Iterable<Employee> ep = employeeRepository.findAll();

            ExelFile exl = new ExelFile(idExcelFile,file.getOriginalFilename());
            excelFileRepository.save(exl);




            System.out.print("message"+
                    "You successfully uploaded '" + file.getOriginalFilename() + "'" );
            //exl.setName(file.getOriginalFilename());
            //excelFileRepository.save(exl);

        } catch (IOException e) {
            System.out.print("message"+
                    "Failure occured during upload '" + file.getOriginalFilename() + "'");
            e.printStackTrace();
        }


        System.out.print(("upload"+"message"+"You successfully uploaded '" + file.getOriginalFilename() + "'"));

    }
}
