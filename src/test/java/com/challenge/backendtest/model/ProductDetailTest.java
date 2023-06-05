package com.challenge.backendtest.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@AutoConfigureMockMvc
@SpringBootTest
class ProductDetailTest {
    

    private ProductDetail productDetail;

    @BeforeEach
    public void setUp() {
        productDetail = new ProductDetail();
    }

    @Test
    public void setId_shouldSetIdCorrectly() {
        productDetail.setId("1");
        assertEquals("1", productDetail.getId());
    }

    @Test
    public void setName_shouldSetNameCorrectly() {
        productDetail.setName("Blazer");
        assertEquals("Blazer", productDetail.getName());
    }

    @Test
    public void setPrice_shouldSetPriceCorrectly() {
        productDetail.setPrice(20.0);
        assertEquals(20.0, productDetail.getPrice());
    }

    @Test
    public void setAvailability_shouldSetAvailabilityCorrectly() {
        productDetail.setAvailability(true);
        assertEquals(true, productDetail.isAvailability());
    }
}
