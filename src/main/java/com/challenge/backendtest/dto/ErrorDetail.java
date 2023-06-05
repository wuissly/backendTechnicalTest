package com.challenge.backendtest.dto;

import lombok.*;

@Builder
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private String code;
    private String mensaje;
}
