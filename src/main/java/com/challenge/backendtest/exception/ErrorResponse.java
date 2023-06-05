package com.challenge.backendtest.exception;

import com.challenge.backendtest.dto.ErrorDetail;
import lombok.*;

@Builder
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse  {

    private String code;
    private String message;
    private ErrorDetail errors;
}