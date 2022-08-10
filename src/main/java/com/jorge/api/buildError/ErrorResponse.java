package com.jorge.api.buildError;

import lombok.Data;

@Data
public class ErrorResponse {
    private int code;
    private String error;
}
