package com.jonatas.graduation_control_api.controller;

import com.jonatas.graduation_control_api.dto.AttendancesRequest;
import com.jonatas.graduation_control_api.dto.AttendancesResponse;
import com.jonatas.graduation_control_api.service.AttendancesService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jonatas.graduation_control_api.configuration.LoggerConfiguration.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/attendances")
public class AttendancesController {

    @Autowired
    AttendancesService attendancesService;

    private final Logger logger = getLogger(AttendancesController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AttendancesResponse> getAllAttendances(){
        logger.info("Listing all attendances");

        return attendancesService.getAllAttendances();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AttendancesResponse getAttendanceById(@PathVariable String attendanceId) {
        logger.info("Getting attendance by id {}", attendanceId);

        return attendancesService.getAttendanceById(attendanceId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendancesResponse createAttendance(@RequestBody AttendancesRequest attendancesRequest){
        logger.info("Creating a new attendance");

        return attendancesService.createAttendances(attendancesRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AttendancesResponse updateAttendance(
            @PathVariable String attendanceId,
            @RequestBody AttendancesRequest attendancesRequest
    ){
        logger.info("Updating attendance with id {}", attendanceId);

        return attendancesService.updateAttendance(attendanceId, attendancesRequest);
    }

    @DeleteMapping("/{attendanceId}")
    public void deleteAttendance(@PathVariable String attendanceId) {
        logger.info("Deleting attendance with id {}", attendanceId);

        attendancesService.deleteAttendance(attendanceId);
    }
}


