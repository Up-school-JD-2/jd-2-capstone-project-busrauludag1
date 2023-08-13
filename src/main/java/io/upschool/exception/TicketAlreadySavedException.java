package io.upschool.exception;

import io.upschool.dto.response.BaseResponse;
import io.upschool.dto.response.TicketResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class TicketAlreadySavedException extends RuntimeException{
    public TicketAlreadySavedException(String message) {
        super(message);
    }

    public TicketAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }

    @ExceptionHandler(TicketAlreadySavedException.class)
    public ResponseEntity<Object> handleTicketAlreadySavedException(final TicketAlreadySavedException exception,
                                                                    final WebRequest request) {

        var response = BaseResponse.<TicketResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
