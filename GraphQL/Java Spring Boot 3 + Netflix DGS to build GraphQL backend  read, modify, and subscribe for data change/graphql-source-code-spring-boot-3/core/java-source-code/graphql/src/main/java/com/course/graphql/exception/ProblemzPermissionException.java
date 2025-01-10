package com.course.graphql.exception;

public class ProblemzPermissionException extends RuntimeException {
    public ProblemzPermissionException() {
        super("You are not allowed to access this operation");
    }
}
