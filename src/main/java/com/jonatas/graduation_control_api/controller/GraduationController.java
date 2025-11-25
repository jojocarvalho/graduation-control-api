package com.jonatas.graduation_control_api.controller;

import com.jonatas.graduation_control_api.dto.GraduationRequest;
import com.jonatas.graduation_control_api.dto.GraduationResponse;
import com.jonatas.graduation_control_api.service.GraduationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jonatas.graduation_control_api.configuration.LoggerConfiguration.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/graduations")
public class GraduationController {

    @Autowired
    GraduationService graduationService;

    private final Logger logger = getLogger(GraduationController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GraduationResponse> getAllGraduations() {
        logger.info("Listing all graduations");

        return graduationService.getAllGraduations();
    }

    @GetMapping("/{graduationId}")
    @ResponseStatus(HttpStatus.OK)
    public GraduationResponse getGraduationById(@PathVariable String graduationId) {
        logger.info("Getting graduation by id {}", graduationId);

        return graduationService.getGraduationById(graduationId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GraduationResponse createGraduation(@Valid @RequestBody GraduationRequest graduationRequest) {
        logger.info("Creating a new graduation");

        return graduationService.createGraduation(graduationRequest);
    }

    @PatchMapping("/{graduationId}")
    @ResponseStatus(HttpStatus.OK)
    public GraduationResponse updateGraduation(
            @PathVariable String graduationId,
            @Valid @RequestBody GraduationRequest graduationRequest
    ) {
        logger.info("Updating graduation with id {}", graduationId);

        return graduationService.updateGraduation(graduationId, graduationRequest);
    }

    @DeleteMapping("/{graduationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGraduation(@PathVariable String graduationId) {
        logger.info("Deleting graduation by id {}",  graduationId);

        graduationService.deleteGraduation(graduationId);
    }
}
