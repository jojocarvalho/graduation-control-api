package com.jonatas.graduation_control_api.dto;

import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlansRequest {

    private String name;

    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    private BigDecimal price;
}
