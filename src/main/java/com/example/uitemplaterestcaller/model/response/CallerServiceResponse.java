package com.example.uitemplaterestcaller.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallerServiceResponse<T> {
    private String message;

    private String description;

    private int statusCode;

    // T is generic data type and all other different data types can store into this variable
    private T responseData;
}
