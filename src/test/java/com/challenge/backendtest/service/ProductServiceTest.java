package com.challenge.backendtest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.backendtest.config.clients.SimilarProductsDetailsClient;
import com.challenge.backendtest.exception.ProductNotFoundException;
import com.challenge.backendtest.model.ProductDetail;

import feign.FeignException;


@AutoConfigureMockMvc
@SpringBootTest
class ProductServiceTest {

    @Mock
    private SimilarProductsDetailsClient similarProductsDetailsClient;

    @InjectMocks
    private ProductService productService;

    @Test
    public void getProductSimilarTest() {
        ProductDetail product = new ProductDetail("1", "Blazer", 20.00, true);
        List<String> products = List.of("1", "2");
        when(similarProductsDetailsClient.getSimilarProductIds("1")).thenReturn(products);
        when(similarProductsDetailsClient.getProductById("1")).thenReturn(product);
        when(similarProductsDetailsClient.getProductById("2")).thenThrow(FeignException.NotFound.class);

        try {
            productService.getProductSimilar("1");
        } catch (Exception e) {
            assertEquals(ProductNotFoundException.class, e.getClass());
        }
    }
    
}
