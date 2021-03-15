package com.boada.unmsm.exam.web.error;

import com.boada.unmsm.exam.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ComponentsQuantityException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleComponentQuantity(ComponentsQuantityException ex) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());
        return message;
    }

    @ExceptionHandler(TypeProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleTypeProductNotFound(TypeProductNotFoundException ex) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());

        return message;
    }

    @ExceptionHandler(SamePartNumberException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleSamePartNumber(SamePartNumberException ex) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());

        return message;
    }

    @ExceptionHandler(PartNumberNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handlePartNumberNotFound() {

    }

    @ExceptionHandler(ProductsNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleProductsNotFound() {

    }
}
