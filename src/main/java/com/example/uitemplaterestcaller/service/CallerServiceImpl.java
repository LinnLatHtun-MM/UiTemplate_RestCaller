package com.example.uitemplaterestcaller.service;

import com.example.uitemplaterestcaller.config.AppConfig;
import com.example.uitemplaterestcaller.model.request.EmpList;
import com.example.uitemplaterestcaller.model.request.Employee;
import com.example.uitemplaterestcaller.model.request.StringList;
import com.example.uitemplaterestcaller.model.response.CallerServiceResponse;
import com.sun.xml.internal.ws.api.message.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restcaller
 * @package: com.example.uitemplaterestcaller.service
 */

@Slf4j
@Service
public class CallerServiceImpl implements CallerService {

    @Autowired
    AppConfig appConfig;

    @Autowired
    RestTemplate restTemplate;

    @Value("${callerapp.api.receiverservice.basicauth.credentials.username}")
    private String username;

    @Value("${callerapp.api.receiverservice.basicauth.credentials.username}")
    private String password;


    @Value("classpath:test.xlsx") // read file with given name under resources folder
    Resource testResourceFile;


    @Override
    public CallerServiceResponse requestBodyMethod(Employee employee) {

        try {
            log.info("Api Calling Info, URL: {}, Request Data: {}", appConfig.getRequestBodyObjectUrl(), employee);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, headers);

            ResponseEntity<Employee> response = restTemplate.postForEntity(appConfig.getRequestBodyObjectUrl(), httpEntity, Employee.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Body Obj  Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);
        }
    }

    @Override
    public CallerServiceResponse requestBodyObjMethod(EmpList empList) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data: {}", appConfig.getRequestBodyObjectListUrl(), empList);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<EmpList> httpEntity = new HttpEntity<>(empList, headers);

            ResponseEntity<EmpList> response = restTemplate.postForEntity(appConfig.getRequestBodyObjectListUrl(), httpEntity, EmpList.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Body Object List Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);
        }
    }

    @Override
    public CallerServiceResponse requestBodyStringListMethod(StringList stringList) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data: {}", appConfig.getRequestBodyStringListUrl(), stringList);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<StringList> httpEntity = new HttpEntity<>(stringList, headers);

            ResponseEntity<StringList> response = restTemplate.postForEntity(appConfig.getRequestBodyStringListUrl(), httpEntity, StringList.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Body String List Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse pathVariableWithIdMethod(Integer id) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data: {}", appConfig.getRequestPathVariableUrl(), id);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.getForEntity(appConfig.getRequestPathVariableUrl(), String.class, id);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Path Variable Integer Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse multiplePathVariablesMethod(Integer id, String name) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data id: {}, Request Data name: {}", appConfig.getRequestMultiPathVariablesUrl(), id, name);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.getForEntity(appConfig.getRequestMultiPathVariablesUrl(), String.class, id, name);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Multiple Path Variable Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse requestParamMethod(Integer id) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data: {}", appConfig.getRequestParamUrl(), id);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            UriComponents builder = UriComponentsBuilder.fromHttpUrl(appConfig.getRequestParamUrl())
                    .queryParam("id", id)
                    .build();


            ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                    String.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse multipleRequestParamMethod(Integer id, String name) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data id: {}, Request Data name: {}", appConfig.getRequestMultiParamsUrl(), id, name);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            UriComponents builder = UriComponentsBuilder.fromHttpUrl(appConfig.getRequestMultiParamsUrl())
                    .queryParam("id", id)
                    .queryParam("name", name)
                    .build();
            ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                    String.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse pathVariableAndParamMethod(Integer id, String name) {
        try {
            log.info("Api Calling Info, URL: {}, Request Data id: {}, Request Data name: {}", appConfig.getRequestPathVariableAndParamsUrl(), id, name);
            UriComponents builder = UriComponentsBuilder.fromHttpUrl(appConfig.getRequestPathVariableAndParamsUrl())
                    .queryParam("name", name)
                    .build();

            ResponseEntity<String> response = restTemplate.getForEntity(
                    builder.toString(), String.class, id);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse requestFromHeaderMethod() {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBasicAuth(username, password);

            log.info("Api Calling Info, URL: {}, Request Data From Header: {}", appConfig.getRequestFromHeaderUrl(), headers);
            HttpEntity httpEntity = new HttpEntity(headers);
            ResponseEntity<String> response = restTemplate.exchange(appConfig.getRequestFromHeaderUrl(), HttpMethod.GET, httpEntity, String.class);
            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());
            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);

        }
    }

    @Override
    public CallerServiceResponse requestFromHeaderAndParamMethod() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluQGdtYWlsLmNvbSIsInJvbGVzIjpbIkFETUlOIiwiTUFOQUdFUiIsIk5PUk1BTF9VU0VSIiwiU1VQRVJfQURNSU4iXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3NwcmluZy1zZWN1cml0eS1qd3QvbG9naW4iLCJleHAiOjE2NjMwMTczMDl9.qWnl1aA63p2XXchc6P4Kv2yS4ghVCnEdwB0-06-0qXU";
            String authorizationHeaderValue = "Bearer " + token;

            headers.add("authorization", authorizationHeaderValue);

            log.info("Api Calling Info, URL: {}, Request Data From Header: {}", appConfig.getRequestFromHeaderUrl(), headers);
            HttpEntity httpEntity = new HttpEntity<>(headers);

            UriComponents builder = UriComponentsBuilder.fromHttpUrl(appConfig.getRequestFromHeaderAndRequestParamUrl())
                    .queryParam("name", "Linn Lat Htun")
                    .build();

            ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, String.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());

            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);
        }

    }

    @Override
    public CallerServiceResponse requestFromHeaderAndRequestBodyMethod() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluQGdtYWlsLmNvbSIsInJvbGVzIjpbIkFETUlOIiwiTUFOQUdFUiIsIk5PUk1BTF9VU0VSIiwiU1VQRVJfQURNSU4iXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3NwcmluZy1zZWN1cml0eS1qd3QvbG9naW4iLCJleHAiOjE2NjMwMTczMDl9.qWnl1aA63p2XXchc6P4Kv2yS4ghVCnEdwB0-06-0qXU";
            String authorizationHeaderValue = "Bearer " + token;

            headers.add("authorization", authorizationHeaderValue);

            Employee employee = new Employee();
            employee.setName("Linn Lat Htun");
            employee.setAddress("Yangon");
            employee.setPhNo("0978787878789");
            log.info("Api Calling Info, URL: {}, Request Data From Header: {}, Request Entity: {}", appConfig.getRequestFromHeaderAndRequestBodyUrl(), headers, employee);
            HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, headers);

            ResponseEntity<String> response = restTemplate.exchange(appConfig.getRequestFromHeaderAndRequestBodyUrl(), HttpMethod.POST, httpEntity, String.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());

            return callerServiceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);
        }

    }

    @Override
    public CallerServiceResponse fileUploadMethod() {
        try {

            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("file", testResourceFile);

            HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap, header);

            log.info("API Calling info, url: {}, request data: {}, headers:{}", appConfig.getRequestFileUploadUrl(), httpEntity.getBody(), httpEntity.getHeaders());

            ResponseEntity<String> response = restTemplate.exchange(appConfig.getRequestFileUploadUrl(), HttpMethod.POST, httpEntity, String.class);
            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());

            return callerServiceResponse;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);
        }
    }

    @Override
    public CallerServiceResponse fromHeaderAndBulkFileUplpadMethod() {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluQGdtYWlsLmNvbSIsInJvbGVzIjpbIkFETUlOIiwiTUFOQUdFUiIsIk5PUk1BTF9VU0VSIiwiU1VQRVJfQURNSU4iXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3NwcmluZy1zZWN1cml0eS1qd3QvbG9naW4iLCJleHAiOjE2NjMwMTczMDl9.qWnl1aA63p2XXchc6P4Kv2yS4ghVCnEdwB0-06-0qXU";
            String authorizationHeaderValue = "Bearer " + token;

            httpHeaders.set("Authorization", authorizationHeaderValue);
            //Get Files from under resource folder
            Resource re = getFileResource("test.xlsx");

            //Adding files to map
            MultiValueMap<String, Object> files = new LinkedMultiValueMap<>();
            files.add("file", getFileResource("test.xlsx"));
            files.add("file", getFileResource("test1.xlsx"));

            HttpEntity httpEntity = new HttpEntity(files, httpHeaders);
            log.info("API Calling info, url: {}, request data: {}, headers:{}", appConfig.getRequestFromHeaderAndBulkFileUploadUrl(), httpEntity.getBody(), httpEntity.getHeaders());

            ResponseEntity<String> response = restTemplate.exchange(appConfig.getRequestFromHeaderAndBulkFileUploadUrl(), HttpMethod.POST, httpEntity, String.class);

            log.info("Third Party Response Status Code: {}", response.getStatusCode().value());
            log.info("Third Party Response Data: {}", response.getBody());

            CallerServiceResponse callerServiceResponse = new CallerServiceResponse();
            if (response.getStatusCode() == HttpStatus.OK) {
                callerServiceResponse.setMessage("Success");
            } else {
                callerServiceResponse.setMessage("Fail from third party");
            }

            callerServiceResponse.setDescription("Calling Request Param Response Third Party Api");
            callerServiceResponse.setResponseData(response.getBody());
            callerServiceResponse.setStatusCode(response.getStatusCode().value());

            return callerServiceResponse;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: {}", e.getMessage());
            return new CallerServiceResponse("Error Calling Third Party Api", e.getMessage(), 500, null);
        }

    }

    public Resource getFileResource(String fileName) {
        return new ClassPathResource(fileName);
    }


}
