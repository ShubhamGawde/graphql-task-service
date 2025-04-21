package com.taskmanagement.taskservice.exceptionhandler;

import com.taskmanagement.taskservice.customexception.TaskNotFoundException;
import com.taskmanagement.taskservice.customexception.UserNotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler(UserNotFoundException.class)
    public GraphQLError handleUserNotFoundException(UserNotFoundException ex) {
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.NOT_FOUND)
                .build();
    }

    @GraphQlExceptionHandler(TaskNotFoundException.class)
    public GraphQLError handleTaskNotFoundException(TaskNotFoundException ex) {
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.NOT_FOUND)
                .build();
    }
}
