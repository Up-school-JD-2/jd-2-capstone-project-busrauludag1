package io.upschool.exception;

import io.upschool.dto.response.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);

        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleAll(final Exception exception, final WebRequest request) {
        System.out.println("Error occurred. MESSAGE:" + exception.getMessage());
        var response = BaseResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
