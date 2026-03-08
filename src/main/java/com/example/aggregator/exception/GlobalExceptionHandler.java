package com.example.aggregator.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.OffsetDateTime;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleCustomerNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request
    ) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        problem.setTitle("User not Found");
        problem.setType(URI.create("https://api.mondomaine.ch/problems/customer-not-found"));
        problem.setInstance(URI.create(request.getRequestURI()));

        problem.setProperty("errorCode", "CUSTOMER_NOT_FOUND");
        problem.setProperty("UserId", ex.getCustomerId());
        problem.setProperty("timestamp", OffsetDateTime.now());

        return problem;
    }
}
