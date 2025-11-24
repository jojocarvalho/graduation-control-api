package com.jonatas.graduation_control_api.controller;

import com.jonatas.graduation_control_api.dto.ClassesRequest;
import com.jonatas.graduation_control_api.dto.ClassesResponse;
import com.jonatas.graduation_control_api.service.ClassesService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jonatas.graduation_control_api.configuration.LoggerConfiguration.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    ClassesService classesService;

    private final Logger logger = getLogger(ClassesController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClassesResponse> getAllClasses() {
        logger.info("Listing all classes");

        return classesService.getAllClasses();
    }

    @GetMapping("/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public ClassesResponse getClassById(@PathVariable String classId) {
        logger.info("Getting class by id {}", classId);

        return classesService.getClassById(classId);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassesResponse createClass(@RequestBody ClassesRequest classRequest) {
        logger.info("Creating a new class");

        return classesService.createClass(classRequest);
    }

    @PutMapping("/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public ClassesResponse updateClass(
            @PathVariable String classId,
            @RequestBody ClassesResponse classRequest) {
        logger.info("Updating class with id {}", classId);

        return classesService.updateClass(classId, classRequest);
    }


    @DeleteMapping("/{classId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClass(@PathVariable String classId) {
        logger.info("Deleting class with id {}", classId);

        classesService.deleteClass(classId);
    }
}
