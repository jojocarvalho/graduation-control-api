package com.jonatas.graduation_control_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GraduationRequest {

    private String beltColor;

    private int degree;

    private LocalDateTime graduationDate;

    private String clientId;
}
