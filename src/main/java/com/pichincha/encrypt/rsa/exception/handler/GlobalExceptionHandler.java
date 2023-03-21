package com.pichincha.encrypt.rsa.exception.handler;

import com.pichincha.encrypt.rsa.service.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    private static ErrorResponse buildErrorResponse(int code, String message, String description) {
        return ErrorResponse.builder()
                .statusCode(code)
                .timestamp(new Date())
                .message(message)
                .description(description).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        String errorFields = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        log.error("methodArgumentNotValidExceptionHandler: {} ", errorFields);
        ErrorResponse errorResponse = buildErrorResponse(HttpStatus.BAD_REQUEST.value(), errorFields, null);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
