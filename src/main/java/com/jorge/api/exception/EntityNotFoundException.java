package com.jorge.api.exception;

import com.jorge.api.buildError.ErrorResponse;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends Exception{
  public EntityNotFoundException(String message){
    super(message);
  }

  public ErrorResponse errorResponse(){
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(HttpStatus.NOT_FOUND.value());
    errorResponse.setError(super.getMessage());
    return errorResponse;
  }
}
