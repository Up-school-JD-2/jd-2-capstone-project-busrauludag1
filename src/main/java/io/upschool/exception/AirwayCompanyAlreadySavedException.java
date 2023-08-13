package io.upschool.exception;

public class AirwayCompanyAlreadySavedException extends RuntimeException{

    public AirwayCompanyAlreadySavedException(String message) {
        super(message);
    }

    public AirwayCompanyAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }
}
