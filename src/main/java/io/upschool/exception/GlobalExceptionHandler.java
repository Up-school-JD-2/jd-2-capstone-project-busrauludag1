package io.upschool.exception;

import io.upschool.dto.response.*;
import io.upschool.dto.response.AirportResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;
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
}


/*
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatusCode status,
                                                                   WebRequest request) {
        final var errorMessage =
                MessageFormat.format("No handler found for {0} {1}", ex.getHttpMethod(), ex.getRequestURL());
        System.out.println(errorMessage);
        var response = BaseResponse.<Object>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(final Exception exception, final WebRequest request) {
        System.out.println("Error occurred. MESSAGE:" + exception.getMessage());
        var response = BaseResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(TicketAlreadySavedException.class)
    public ResponseEntity<Object> handleTicketAlreadySavedException(final TicketAlreadySavedException exception,
                                                                    final WebRequest request) {
        System.out.println("This ticket is already purchased! Try again. MESSAGE: " + exception.getMessage());
        System.out.println(request.toString());
        var response = BaseResponse.<TicketResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AirportAlreadySavedException.class)
    public ResponseEntity<Object> handleAirportAlreadySavedException(final AirportAlreadySavedException exception,
                                                                    final WebRequest request) {
        System.out.println("This airport is already saved! MESSAGE: " + exception.getMessage());
        System.out.println(request.toString());
        var response = BaseResponse.<AirportResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AirwayCompanyAlreadySavedException.class)
    public ResponseEntity<Object> handleAirwayCompanyAlreadySavedException(final AirwayCompanyAlreadySavedException exception,
                                                                    final WebRequest request) {
        System.out.println("This company is already saved! MESSAGE: " + exception.getMessage());
        System.out.println(request.toString());
        var response = BaseResponse.<CompanyResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(FlightAlreadySavedException.class)
    public ResponseEntity<Object> handleFlightAlreadySavedException(final FlightAlreadySavedException exception,
                                                                           final WebRequest request) {
        System.out.println("This flight is already saved! MESSAGE: " + exception.getMessage());
        System.out.println(request.toString());
        var response = BaseResponse.<FlightResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(PassengerAlreadySavedException.class)
    public ResponseEntity<Object> handlePassengerAlreadySavedException(final PassengerAlreadySavedException exception,
                                                                    final WebRequest request) {
        System.out.println("This passenger is already saved! MESSAGE: " + exception.getMessage());
        System.out.println(request.toString());
        var response = BaseResponse.<PassengerResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(RouteAlreadySavedException.class)
    public ResponseEntity<Object> handleRouteAlreadySavedException(final RouteAlreadySavedException exception,
                                                                       final WebRequest request) {
        System.out.println("This route is already saved! MESSAGE: " + exception.getMessage());
        System.out.println(request.toString());
        var response = BaseResponse.<RouteResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .isSuccess(false)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}

*/

