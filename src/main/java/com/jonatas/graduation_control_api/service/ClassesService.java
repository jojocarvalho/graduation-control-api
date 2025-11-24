package com.jonatas.graduation_control_api.service;

import com.jonatas.graduation_control_api.dto.ClassesRequest;
import com.jonatas.graduation_control_api.dto.ClassesResponse;
import com.jonatas.graduation_control_api.model.ClassesModel;
import com.jonatas.graduation_control_api.repository.ClassesRepository;
import com.jonatas.graduation_control_api.utils.Converter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ClassesService {

    @Autowired
    ClassesRepository classesRepository;

    private final Logger logger = getLogger(ClassesService.class);

    public List<ClassesResponse> getAllClasses() {
        logger.info("Listing all classes");

        return classesRepository
                .findAll()
                .stream()
                .map(Converter::toClassesResponse)
                .toList();
    }

    public ClassesResponse getClassById(String classId) {
        logger.info("Getting class by id {}", classId);

        ClassesModel classesModel = classesRepository.findById(classId).orElseThrow();


        return Converter.toClassesResponse(classesModel);
    }

    public ClassesResponse createClass(ClassesRequest classRequest) {
        logger.info("Creating a new class");

        ClassesModel classesModel = Converter.toClassesModel(classRequest);

        classesRepository.save(classesModel);

        return Converter.toClassesResponse(classesModel);
    }

    public ClassesResponse updateClass(String classId, ClassesResponse classRequest) {
        logger.info("Updating class with id {}", classId);

        ClassesModel classesModel = classesRepository
                .findById(classId)
                .orElseThrow();

        classesModel.setClassName(classRequest.getClassName());
        classesModel.setClassDayOfWeek(classRequest.getClassDayOfWeek());
        classesModel.setClassTime(classRequest.getClassTime());

        classesRepository.save(classesModel);

        return Converter.toClassesResponse(classesModel);
    }

    public void deleteClass(String classId) {
        logger.info("Deleting class with id {}", classId);

        ClassesModel classesModel = classesRepository
                .findById(classId)
                .orElseThrow();

        classesRepository.delete(classesModel);
    }
}
