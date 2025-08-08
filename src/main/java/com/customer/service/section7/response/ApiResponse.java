package com.customer.service.section7.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
}
