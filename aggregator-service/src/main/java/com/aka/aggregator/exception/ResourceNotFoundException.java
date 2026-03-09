package com.aka.aggregator.exception;

public class ResourceNotFoundException extends RuntimeException {
    private final Long customerId;

    public ResourceNotFoundException(Long customerId) {
        super("No user found " + customerId);
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

}
