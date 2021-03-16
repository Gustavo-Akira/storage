package br.com.gustavoakira.industry.storage.resource.impl;

import br.com.gustavoakira.industry.storage.exception.CustomExceptionResponse;
import br.com.gustavoakira.industry.storage.exception.ProductNotFoundException;
import br.com.gustavoakira.industry.storage.resource.ErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorResourceImpl implements ErrorResource {
    @Override
    @ExceptionHandler(value =  {ProductNotFoundException.class})
    public ResponseEntity<CustomExceptionResponse> handleNotFoundExceptions(ProductNotFoundException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse("NOT_FOUND",exception.getMessage());
        response.setTime(LocalDateTime.now());
        response.setStatus((HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<CustomExceptionResponse> handleGenericExceptions(RuntimeException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse("INTERNAL_SERVER_ERROR",exception.getMessage() );
        response.setTime(LocalDateTime.now());
        response.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
