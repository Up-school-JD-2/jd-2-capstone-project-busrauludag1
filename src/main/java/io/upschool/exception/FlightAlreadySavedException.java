package io.upschool.exception;

import io.upschool.dto.response.BaseResponse;
import io.upschool.dto.response.FlightResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class FlightAlreadySavedException extends RuntimeException{

    public FlightAlreadySavedException(String message) {
        super(message);
    }

    public FlightAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    @ExceptionHandler(FlightAlreadySavedException.class)
    public ResponseEntity<Object> handleFlightAlreadySavedException(final FlightAlreadySavedException exception,
                                                                    final WebRequest request) {

        var response = BaseResponse.<FlightResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
