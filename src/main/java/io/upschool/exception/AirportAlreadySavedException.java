package io.upschool.exception;


import io.upschool.dto.response.AirportResponse;
import io.upschool.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class AirportAlreadySavedException extends RuntimeException {
    public AirportAlreadySavedException(String message) {
        super(message);
    }

    public AirportAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    @ExceptionHandler(AirportAlreadySavedException.class)
    public ResponseEntity<Object> handleAirportAlreadySavedException(final AirportAlreadySavedException exception,
                                                                     final WebRequest request) {

        var response = BaseResponse.<AirportResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
