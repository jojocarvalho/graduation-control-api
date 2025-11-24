package com.jonatas.graduation_control_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
public class EnrollmentsModel {

    @Id
    private String enrollmenstId;

    @Column(name = "student_code", nullable = false, unique = true)
    private String studentCode;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientModel client;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private PlansModel plan;
}
