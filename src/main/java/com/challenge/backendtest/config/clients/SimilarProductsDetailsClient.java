package com.challenge.backendtest.config.clients;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import com.challenge.backendtest.model.ProductDetail;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface SimilarProductsDetailsClient {

    @GetMapping(value = "/product/{productId}")
    ProductDetail getProductById(@PathVariable String productId);

    @GetMapping(value = "/product/{productId}/similarids")
    List<String> getSimilarProductIds(@PathVariable String productId);
    
}
