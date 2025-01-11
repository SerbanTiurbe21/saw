package com.saw.backend.exception.product;

public class ProductDetailsNotEmptyException extends RuntimeException {
    public ProductDetailsNotEmptyException(final String message) {
        super(message);
    }
}
