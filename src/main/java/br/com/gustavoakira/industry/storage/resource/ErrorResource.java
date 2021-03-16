package br.com.gustavoakira.industry.storage.resource;

import br.com.gustavoakira.industry.storage.exception.CustomExceptionResponse;
import br.com.gustavoakira.industry.storage.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ErrorResource {
    ResponseEntity<CustomExceptionResponse> handleNotFoundExceptions(ProductNotFoundException exception);
    ResponseEntity<CustomExceptionResponse> handleGenericExceptions(RuntimeException exception);
}
