package com.challenge.backendtest.excepption;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.challenge.backendtest.exception.NotConnectionCLientException;
import com.challenge.backendtest.exception.ProductNotFoundException;
import com.challenge.backendtest.exception.handler.RestExceptionHandler;


@AutoConfigureMockMvc
@SpringBootTest
class RestExceptionTest {

    @Test
    void testRestExceptionHandler() {
    // Test ProductNotFoundException
    ProductNotFoundException ex = new ProductNotFoundException("001", "Product not found");
    var exceptionNotFound = new RestExceptionHandler().productNotFoundException(ex);
    assertEquals(HttpStatus.BAD_REQUEST.value(), Integer.valueOf(exceptionNotFound.getCode()));
    assertEquals("001", exceptionNotFound.getErrors().getCode());
    assertEquals("Product not found", exceptionNotFound.getErrors().getMensaje());
    
    // Test NotConnectionCLientException
    NotConnectionCLientException ex2 = new NotConnectionCLientException("002", "Failed to connect to client");
    var exceptionNotConection = new RestExceptionHandler().NotConnectionCLientException(ex2);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.valueOf(exceptionNotConection.getCode()));
    assertEquals("002", exceptionNotConection.getErrors().getCode());
    assertEquals("Failed to connect to client", exceptionNotConection.getErrors().getMensaje());
}
}
