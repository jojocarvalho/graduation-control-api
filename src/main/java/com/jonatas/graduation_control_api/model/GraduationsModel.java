package com.jonatas.graduation_control_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "graduations")
@Getter
@Setter
public class GraduationsModel {

    @Id
    private String graduationId;

    @Column(name = "belt_color", nullable = false)
    private String beltColor;

    @Column(name = "degree", nullable = false)
    private int degree;

    @Column(name = "graduation_date", nullable = false)
    private LocalDateTime graduationDate;

    @Column(name = "client_id", nullable = false)
    private String clientId;


}
