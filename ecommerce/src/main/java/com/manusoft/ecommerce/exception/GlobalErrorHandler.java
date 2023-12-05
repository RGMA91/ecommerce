package com.manusoft.ecommerce.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalErrorHandler {

    Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandler.class);
    @ExceptionHandler({PriceNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlePriceNotFoundException(PriceNotFoundException iae, WebRequest request) {
        LOGGER.error(">> GlobalErrorHandler handlePriceNotFoundException()");
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                iae.getMessage(),
                request.getDescription(true));
        LOGGER.error("<< GlobalErrorHandler handlePriceNotFoundException() errorMessage: {}", errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
