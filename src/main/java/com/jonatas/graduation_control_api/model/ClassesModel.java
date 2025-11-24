package com.jonatas.graduation_control_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class ClassesModel {

    @Id
    private String classesId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek classDayOfWeek;

    @Column(name = "class_time", nullable = false)
    private LocalTime classTime;
}
