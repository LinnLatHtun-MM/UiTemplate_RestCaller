package com.example.uitemplaterestcaller.service;

import com.example.uitemplaterestcaller.model.request.EmpList;
import com.example.uitemplaterestcaller.model.request.Employee;
import com.example.uitemplaterestcaller.model.request.StringList;
import com.example.uitemplaterestcaller.model.response.CallerServiceResponse;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.Map;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restcaller
 * @package: com.example.uitemplaterestcaller.service
 */

public interface CallerService {
    CallerServiceResponse requestBodyMethod(Employee employee);

    CallerServiceResponse requestBodyObjMethod(EmpList empList);
    CallerServiceResponse requestBodyStringListMethod(StringList stringList);

    CallerServiceResponse pathVariableWithIdMethod(Integer id);

    CallerServiceResponse multiplePathVariablesMethod(Integer id,String name);

    CallerServiceResponse requestParamMethod(Integer id);

    CallerServiceResponse multipleRequestParamMethod(Integer id,String name);

    CallerServiceResponse pathVariableAndParamMethod(Integer id,String name);
    CallerServiceResponse requestFromHeaderMethod();

    CallerServiceResponse requestFromHeaderAndParamMethod();

    CallerServiceResponse requestFromHeaderAndRequestBodyMethod();

    CallerServiceResponse fileUploadMethod();

    CallerServiceResponse fromHeaderAndBulkFileUplpadMethod();
}
