package com.saw.backend.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(value = {ProductDetailsNotEmptyException.class})
    public ResponseEntity<Object> handleProductDetailsNotEmptyException(final ProductDetailsNotEmptyException exception) {
        final ProductException productException = new ProductException(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(productException, productException.getHttpStatus());
    }

    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<Object> handleProductNotFoundException(final ProductNotFoundException exception) {
        final ProductException productException = new ProductException(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productException, productException.getHttpStatus());
    }
}
