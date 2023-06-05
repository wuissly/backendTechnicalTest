package com.challenge.backendtest.exception.handler;


import com.challenge.backendtest.dto.ErrorDetail;
import com.challenge.backendtest.exception.ErrorResponse;
import com.challenge.backendtest.exception.ProductNotFoundException;
import com.challenge.backendtest.exception.NotConnectionCLientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
@RequestMapping
@ResponseBody
@Slf4j
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse productNotFoundException(ProductNotFoundException ex) {
        log.error("ProductNotFoundException");
        var errorDetail = ErrorDetail.builder().code(ex.getCodigo()).mensaje(ex.getDescripcion()).build();
        return ErrorResponse.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message(HttpStatus.BAD_REQUEST.name())
                .errors(errorDetail).build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotConnectionCLientException.class)
    public ErrorResponse NotConnectionCLientException(NotConnectionCLientException ex) {
        log.error("NotConnectionCLientException");
        var errorDetail = ErrorDetail.builder().code(ex.getCodigo()).mensaje(ex.getDescripcion()).build();
        return ErrorResponse.builder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).message(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .errors(errorDetail).build();
    }

}
