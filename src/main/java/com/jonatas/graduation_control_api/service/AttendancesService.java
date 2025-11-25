package com.jonatas.graduation_control_api.service;

import com.jonatas.graduation_control_api.dto.AttendancesRequest;
import com.jonatas.graduation_control_api.dto.AttendancesResponse;
import com.jonatas.graduation_control_api.exception.ResourceNotFoundException;
import com.jonatas.graduation_control_api.model.AttendancesModel;
import com.jonatas.graduation_control_api.model.ClassesModel;
import com.jonatas.graduation_control_api.model.ClientModel;
import com.jonatas.graduation_control_api.model.EnrollmentsModel;
import com.jonatas.graduation_control_api.repository.AttendancesRepository;
import com.jonatas.graduation_control_api.repository.ClassesRepository;
import com.jonatas.graduation_control_api.repository.ClientRepository;
import com.jonatas.graduation_control_api.utils.Converter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static com.jonatas.graduation_control_api.configuration.LoggerConfiguration.getLogger;

@Service
public class AttendancesService {

    @Autowired
    AttendancesRepository attendancesRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClassesRepository classesRepository;

    private final Logger logger = getLogger(AttendancesService.class);

    public List<AttendancesResponse> getAllAttendances() {
        logger.info("Listing all attendances");

        List<AttendancesModel> attendances = attendancesRepository.findAll();

        return attendances
                .stream()
                .map(Converter::toAttendancesResponse)
                .toList();
    }

    public AttendancesResponse getAttendanceById(String attendanceId) {
        logger.info("Getting attendance by id {}", attendanceId);

        AttendancesModel attendancesModel = attendancesRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance não encontrado"));

        return Converter.toAttendancesResponse(attendancesModel);
    }

    public AttendancesResponse createAttendances(AttendancesRequest attendancesRequest){
        logger.info("Creating a new attendance");

        ClientModel client = clientRepository.findById(attendancesRequest.getClientId().getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        ClassesModel classes = classesRepository.findById(attendancesRequest.getClassId().getClassesId())
                .orElseThrow(() -> new ResourceNotFoundException("Class não encontrado"));

        AttendancesModel attendancesModel = Converter.toAttendancesModel(attendancesRequest);

        attendancesRepository.save(attendancesModel);

        return Converter.toAttendancesResponse(attendancesModel);
    }

    public AttendancesResponse updateAttendance(String attendanceId, AttendancesRequest attendancesRequest) {
        logger.info("Updating attendance with id {}", attendanceId);

        AttendancesModel attendancesModel = attendancesRepository
                .findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance não encontrado"));


        ClientModel client = clientRepository.findById(attendancesRequest.getClientId().getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        ClassesModel classes = classesRepository.findById(attendancesRequest.getClassId().getClassesId())
                .orElseThrow(() -> new ResourceNotFoundException("Class não encontrado"));

        attendancesRepository.save(attendancesModel);

        return Converter.toAttendancesResponse(attendancesModel);
    }

    public void deleteAttendance(String attendanceId) {
        logger.info("Deleting attendance by id {}", attendanceId);

        attendancesRepository.deleteById(attendanceId);
    }
}
