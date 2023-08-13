package io.upschool.exception;

import io.upschool.dto.response.BaseResponse;
import io.upschool.dto.response.CompanyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class AirwayCompanyAlreadySavedException extends RuntimeException{

    public AirwayCompanyAlreadySavedException(String message) {
        super(message);
    }

    public AirwayCompanyAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    @ExceptionHandler(AirwayCompanyAlreadySavedException.class)
    public ResponseEntity<Object> handleAirwayCompanyAlreadySavedException(final AirwayCompanyAlreadySavedException exception,
                                                                           final WebRequest request) {

        var response = BaseResponse.<CompanyResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
