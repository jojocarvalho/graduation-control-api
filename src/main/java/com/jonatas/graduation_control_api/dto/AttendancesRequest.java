package com.jonatas.graduation_control_api.dto;

import com.jonatas.graduation_control_api.model.ClassesModel;
import com.jonatas.graduation_control_api.model.ClientModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendancesRequest {

    private String attendancesId;

    private LocalDateTime attendanceDate;

    private ClientModel clientId;

    private ClassesModel classId;
}
