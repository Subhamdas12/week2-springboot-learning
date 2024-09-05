package com.week2.week2.advices;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private List<String> subMessage;
}
