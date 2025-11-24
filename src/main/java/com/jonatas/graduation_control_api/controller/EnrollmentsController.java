package com.jonatas.graduation_control_api.controller;

import com.jonatas.graduation_control_api.dto.EnrollmentsRequest;
import com.jonatas.graduation_control_api.dto.EnrollmentsResponse;
import com.jonatas.graduation_control_api.dto.PlansResponse;
import com.jonatas.graduation_control_api.service.EnrollmentsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enrollments")
public class EnrollmentsController {

    @Autowired
    EnrollmentsService enrollmentsService;

    private final Logger logger = getLogger(EnrollmentsController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentsResponse> getAllEnrollments() {
        logger.info("Listing all enrollments");

        return enrollmentsService.getAllEnrollments();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentsResponse getEnrollmentById(@PathVariable String enrollmentId) {
        logger.info("Getting enrollment by id {}", enrollmentId);

        return enrollmentsService.getEnrollmentById(enrollmentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentsResponse createEnrollment(@RequestBody EnrollmentsRequest enrollmentsRequest) {
        logger.info("Creating a new enrollment");

        return enrollmentsService.createEnrollment(enrollmentsRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentsResponse updateEnrollment(
            @PathVariable String enrollmentId,
            @RequestBody EnrollmentsRequest enrollmentsRequest) {
        logger.info("Updating enrollment with id {}", enrollmentId);

        return enrollmentsService.updateEnrollment(enrollmentId, enrollmentsRequest);
    }

    @DeleteMapping("/{enrollmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEnrollment(@PathVariable String enrollmentId) {
        logger.info("Deleting enrollment with id {}", enrollmentId);

        enrollmentsService.deleteEnrollment(enrollmentId);

    }
}
