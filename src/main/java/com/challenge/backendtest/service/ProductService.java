package com.challenge.backendtest.service;

import com.challenge.backendtest.config.clients.SimilarProductsDetailsClient;
import com.challenge.backendtest.dto.response.SimilarProducts;
import com.challenge.backendtest.exception.NotConnectionCLientException;
import com.challenge.backendtest.exception.ProductNotFoundException;
import com.challenge.backendtest.utils.Constants;

import feign.FeignException;
import feign.RetryableException;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private SimilarProductsDetailsClient similarProductsDetailsClient;

    @SneakyThrows
    public SimilarProducts getProductSimilar(String productId) {
        SimilarProducts similarResponse=null;
       try {
        var similarProducts =  similarProductsDetailsClient.getSimilarProductIds(productId)
                .parallelStream()
                .map(similarProductsDetailsClient::getProductById)
                .collect(Collectors.toList());

     
        similarResponse = new SimilarProducts(similarProducts);
        
       } catch (RetryableException  | FeignException.InternalServerError ex) {
            throw new NotConnectionCLientException(Constants.CODE_NOT_CONNECTION_CLIENT, Constants.NOT_CONNECTION_CLIENT);
       }catch(FeignException.NotFound fnf){
            throw new ProductNotFoundException(Constants.CODE_NOT_FOUND,Constants.PRODUCT_NOT_FOUND);
       }

        return similarResponse;
    }

}


