package com.example.uitemplaterestcaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UitemplateRestcallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UitemplateRestcallerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplateBean(){
//        return new RestTemplate();

        // if you don't catch for api error status code, above code line is enough,
        // but if you want to catch for error from api response, you need below code.
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.setErrorHandler(new CustomizeRestTemplateErrorHandler()); // add our customizeRestTemplateErrorHandler class in RestTemplate.
        return restTemplate;
    }
}
