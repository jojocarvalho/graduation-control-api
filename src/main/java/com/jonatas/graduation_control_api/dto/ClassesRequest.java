package com.jonatas.graduation_control_api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class ClassesRequest {

    private String className;

    private DayOfWeek classDayOfWeek;

    private LocalTime classTime;
}
