package com.challenge.backendtest.dto.response;

import com.challenge.backendtest.model.ProductDetail;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "List of similar products to a given one ordered by similarity")
public class SimilarProducts {

    List<ProductDetail> productsDetails;

}
