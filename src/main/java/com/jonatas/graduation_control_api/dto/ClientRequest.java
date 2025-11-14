package com.jonatas.graduation_control_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {

    @NotBlank(message = "CPF é obrigatório.")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres.")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório.")
    private String name;

    @NotNull(message = "Idade é obrigatória.")
    @Min(value = 1, message = "Idade deve ser no mínimo 1.")
    private Integer age;

    @NotBlank(message = "Endereço é obrigatório.")
    private String address;
}
