package com.challenge.backendtest.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import com.challenge.backendtest.dto.response.SimilarProducts;
import com.challenge.backendtest.exception.NotConnectionCLientException;
import com.challenge.backendtest.exception.ProductNotFoundException;
import com.challenge.backendtest.model.ProductDetail;
import com.challenge.backendtest.service.ProductService;



import java.util.Arrays;


@AutoConfigureMockMvc
@SpringBootTest
class ProductSimilarControllerTest {
       
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductSimilarController productSimilarController;


    @Test
    public void testReturn200_GetSimilarProductsWhenSuccess() {
        var products =  Arrays.asList(
            new ProductDetail("1", "Blazer", 20.00, true),
            new ProductDetail("2", "Dress", 15.00, true));

        SimilarProducts similarProducts = new SimilarProducts(products);

        when(productService.getProductSimilar("1")).thenReturn(similarProducts);

        SimilarProducts getProducts = productSimilarController.getProductSimilar("1");
        assertEquals(2, getProducts.getProductsDetails().size());
    }


    @Test
    public void testReturn404_GetSimilarProductsWhenNotFound() {
        when(productService.getProductSimilar("1000")).thenThrow(ProductNotFoundException.class);
        
        try {
            productSimilarController.getProductSimilar("1000");
            fail();
        } catch (ProductNotFoundException e) {
            assertEquals(ProductNotFoundException.class, e.getClass());
        }
    }


    @Test
    public void testReturn500_GetProductsSimilarWhenThrowException() {
        when(productService.getProductSimilar("150")).thenThrow(NotConnectionCLientException.class);
        
        try {
            productSimilarController.getProductSimilar("150");
            fail();
        } catch (NotConnectionCLientException e) {
            assertEquals(NotConnectionCLientException.class, e.getClass());
        }
    }




}
