package com.saw.backend.exception.product;

import org.springframework.http.HttpStatus;

public class ProductException {
    private final String message;
    private final HttpStatus httpStatus;

    public ProductException(final String message, final HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
