package com.example.uitemplaterestcaller.controller;

import com.example.uitemplaterestcaller.config.AppConfig;
import com.example.uitemplaterestcaller.model.request.EmpList;
import com.example.uitemplaterestcaller.model.request.Employee;
import com.example.uitemplaterestcaller.model.request.StringList;
import com.example.uitemplaterestcaller.model.response.CallerServiceResponse;
import com.example.uitemplaterestcaller.service.CallerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restcaller
 * @package: com.example.uitemplaterestcaller.controller
 */

@Slf4j
@RestController
public class CallerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CallerService callerService;

    @PostMapping("/callRequestBodyURL")
    public ResponseEntity requestBodyMethod(@RequestBody Employee employee) {
        try {
            log.info("====Start Calling RequestBody Method ====");
            CallerServiceResponse response = callerService.requestBodyMethod(employee);
            log.info("Response Data: {}", response);
            log.info("==== End Calling RequestBody Method ====");
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error:{} ", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/callRequestBodyObjListURL")
    public ResponseEntity requestBodyListMethod(@RequestBody EmpList employeeList) {
        try {
            log.info("====Start Calling RequestBody Obj List Method ====");
            CallerServiceResponse response = callerService.requestBodyObjMethod(employeeList);
            log.info("Response Data: {}", response);
            log.info("==== End Calling RequestBody Obj List Method ====");
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error:{} ", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/callRequestBodyStringListURL")
    public ResponseEntity requestBodyStringListMethod(@RequestBody StringList stringList) {
        try {
            log.info("==== Start Calling RequestBody String List Method====");
            CallerServiceResponse response = callerService.requestBodyStringListMethod(stringList);
            log.info("Response Data: {}", response);
            log.info("==== End Calling RequestBody String List Method====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/callPathVariableWithIdURL/{id}")
    public ResponseEntity pathVariableWithIdMethod(@PathVariable Integer id) {
        try {
            log.info("==== Start Calling PathVariable With Id Method====");
            CallerServiceResponse response = callerService.pathVariableWithIdMethod(id);
            log.info("Response Data: {}", response);
            log.info("==== End Calling Calling PathVariable With Id Method====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/callMultiplePathVariableURL/{id}/{name}")
    public ResponseEntity multiplePathVariableWithIdMethod(@PathVariable Integer id, @PathVariable String name) {
        try {
            log.info("==== Start Calling Multiple PathVariable Method ====");
            CallerServiceResponse response = callerService.multiplePathVariablesMethod(id, name);
            log.info("Response Data: {}", response);
            log.info("==== End Calling Multiple PathVariable Method ====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/callRequestParamURL")
    public ResponseEntity requestParamMethod(@RequestParam Integer id) {
        try {
            log.info("==== Start Calling Request Param Method ====");
            CallerServiceResponse response = callerService.requestParamMethod(id);
            log.info("Response Data: {}", response);
            log.info("==== End Calling Request Param Method ====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/callMultipleRequestParamURL")
    public ResponseEntity multipleRequestParamMethod(@RequestParam Integer id, @RequestParam String name) {
        try {
            log.info("==== Start Calling Multiple Request Param Method ====");
            CallerServiceResponse response = callerService.multipleRequestParamMethod(id, name);
            log.info("Response Data: {}", response);
            log.info("==== End Calling Multiple Request Param Method ====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/callPathVariableAndParamsURL/{id}")
    public ResponseEntity requestPathVariableAndParamMethod(@PathVariable Integer id, @RequestParam String name) {
        try {
            log.info("==== Start Calling PathVariable and Param Method====");
            CallerServiceResponse response = callerService.pathVariableAndParamMethod(id, name);
            log.info("Response Data: {}", response);
            log.info("==== End Calling Calling PathVariable and Param Method====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/callFromHeaderURL")
    public ResponseEntity requestFromHeaderMethod() {
        try {
            log.info("==== Start Calling Request From Header Method====");
            CallerServiceResponse response = callerService.requestFromHeaderMethod();
            log.info("Response Data: {}", response);
            log.info("==== End Calling Request From Header Method====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/callFromHeaderAndParamURL")
    public ResponseEntity requestFromHeaderAndParamMethod() {
        try {
            log.info("==== Start Calling Request From Header and Param Method====");
            CallerServiceResponse response = callerService.requestFromHeaderAndParamMethod();
            log.info("Response Data: {}", response);
            log.info("==== End Calling Request From Header and Param Method====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/callFromHeaderAndBodyURL")
    public ResponseEntity requestFromHeaderAndBodyMethod() {
        try {
            log.info("==== Start Calling Request From Header and Body Method====");
            CallerServiceResponse response = callerService.requestFromHeaderAndRequestBodyMethod();
            log.info("Response Data: {}", response);
            log.info("==== End Calling Request From Header and Body Method====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/fileUploadURL")
    public ResponseEntity fileUploadMethod() {
        try {
            log.info("==== Start Calling File Upload Method ====");
            CallerServiceResponse response = callerService.fileUploadMethod();
            log.info("Response Data: {}", response);
            log.info("==== End Calling File Upload Method ====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/fromHeaderAndBulkFileUpload")
    public ResponseEntity fromHeaderAndBulkFileUploadMethod() {
        try {
            log.info("==== Start Calling Bulk files Upload and Request Headers Method ====");
            CallerServiceResponse response = callerService.fromHeaderAndBulkFileUplpadMethod();
            log.info("Response Data: {}", response);
            log.info("==== End Calling Bulk Upload and Request Headers Method ====");
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Internal Server Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
