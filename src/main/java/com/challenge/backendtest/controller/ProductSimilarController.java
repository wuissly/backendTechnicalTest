package com.challenge.backendtest.controller;


import com.challenge.backendtest.dto.response.SimilarProducts;
import com.challenge.backendtest.exception.ProductNotFoundException;
import com.challenge.backendtest.service.ProductService;
import com.challenge.backendtest.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.*;


@Slf4j
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductSimilarController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "product/{productId}/similar")
    @Operation(summary = "Similar products", operationId = "get-product-similar")
    @Validated
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description  = "OK"),
        @ApiResponse(responseCode = "404", description  = "Product Not found")
      })
    public SimilarProducts getProductSimilar(
            @Parameter(description = "Product Id") @PathVariable("productId")
            @NotBlank(message = Constants.PRODUCT_REQUEST_EMPTY) String productId
    ) throws ProductNotFoundException {

        log.info("request parameter -> [productId:{}]", productId);
        var response = productService.getProductSimilar(productId);
        log.info("response send: {}", response.toString());

        return response;
    }
}
