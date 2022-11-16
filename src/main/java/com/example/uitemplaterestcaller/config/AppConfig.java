package com.example.uitemplaterestcaller.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restcaller
 * @package: com.example.uitemplaterestcaller.config
 */

@Configuration
@ConfigurationProperties(prefix = "callerapp.api.receiverservice.endpoint")
@Data
public class AppConfig {

    private String requestBodyObjectUrl;

    private String requestBodyObjectListUrl;

    private String requestBodyStringListUrl;

    private String requestPathVariableUrl;

    private String requestMultiPathVariablesUrl;

    private String requestParamUrl;

    private String requestMultiParamsUrl;

    private String requestPathVariableAndParamsUrl;

    private String requestFromHeaderUrl;

    private String requestFromHeaderAndRequestParamUrl;

    private String requestFromHeaderAndRequestBodyUrl;

    private String requestFileUploadUrl;

    private String requestFromHeaderAndBulkFileUploadUrl;


}
