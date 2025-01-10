package com.course.graphql.exception;

public class ProblemzAuthenticationException extends RuntimeException {
    public ProblemzAuthenticationException() {
        super("Invalid credential");
    }
}
