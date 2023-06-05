package com.challenge.backendtest.model;

import lombok.*;

import io.swagger.v3.oas.annotations.media.Schema;


@Data
@Schema(description = "Product detail")
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {

    private String id;
    private String name;
    private double price;
    private boolean availability;

}