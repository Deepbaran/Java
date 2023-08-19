package com.springlearning.Springboot.tutorial.error;

import com.springlearning.Springboot.tutorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundExcetion(DepartmentNotFoundException exception,
                                                                  WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NO_CONTENT, exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(message);
        // For HttpStatus.NO_CONTENT status code, no response will be sent as for 204, No Content is default and extra message is not needed to be sent
    }
}
