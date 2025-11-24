package com.jonatas.graduation_control_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EnrollmentsRequest {

//    private String studentCode; gerar no backend

    private LocalDateTime startTime;

    private String clientId;

    private String plansId;
}
