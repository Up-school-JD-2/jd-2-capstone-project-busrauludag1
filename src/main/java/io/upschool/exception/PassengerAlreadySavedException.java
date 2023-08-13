package io.upschool.exception;

import io.upschool.dto.response.BaseResponse;
import io.upschool.dto.response.PassengerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class PassengerAlreadySavedException extends RuntimeException{

    public PassengerAlreadySavedException(String message) {
        super(message);
    }

    public PassengerAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    @ExceptionHandler(PassengerAlreadySavedException.class)
    public ResponseEntity<Object> handlePassengerAlreadySavedException(final PassengerAlreadySavedException exception,
                                                                       final WebRequest request) {

        var response = BaseResponse.<PassengerResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
