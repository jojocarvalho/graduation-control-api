package com.jonatas.graduation_control_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendances")
@Getter
@Setter
public class AttendancesModel {

    @Id
    private String attendancesId;

    @Column(name = "attendance_date", nullable = false)
    private LocalDateTime attendanceDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientModel clientId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassesModel classId;

}
