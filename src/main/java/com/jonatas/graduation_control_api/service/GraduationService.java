package com.jonatas.graduation_control_api.service;

import com.jonatas.graduation_control_api.dto.ClientResponse;
import com.jonatas.graduation_control_api.dto.GraduationRequest;
import com.jonatas.graduation_control_api.dto.GraduationResponse;
import com.jonatas.graduation_control_api.exception.ResourceNotFoundException;
import com.jonatas.graduation_control_api.model.GraduationsModel;
import com.jonatas.graduation_control_api.repository.GraduationRepository;
import com.jonatas.graduation_control_api.utils.Converter;
import jakarta.persistence.Convert;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jonatas.graduation_control_api.configuration.LoggerConfiguration.getLogger;

@Service
public class GraduationService {

    @Autowired
    GraduationRepository graduationRepository;

    private final Logger logger = getLogger(ClientService.class);

    public List<GraduationResponse> getAllGraduations() {
        logger.info("Listing all graduations");

        List<GraduationsModel> graduations = graduationRepository.findAll();

        return graduations
                .stream()
                .map(Converter::toGraduationResponse)
                .toList();
    }

    public GraduationResponse getGraduationById(String graduationId) {
        logger.info("Getting graduation by id {}", graduationId);

        GraduationsModel graduationsModel = graduationRepository.findById(graduationId).orElseThrow();

        return Converter.toGraduationResponse(graduationsModel);
    }

    public GraduationResponse createGraduation(GraduationRequest graduationRequest) {
        logger.info("Creating a new graduation");

        GraduationsModel graduationsModel = Converter.toGraduationModel(graduationRequest);

        graduationRepository.save(graduationsModel);

        return Converter.toGraduationResponse(graduationsModel);
    }

    public GraduationResponse updateGraduation(String graduationId, GraduationRequest graduationRequest) {
        logger.info("Updating graduation with id {}", graduationId);

        GraduationsModel graduationsModel = graduationRepository
                .findById(graduationId)
                .orElseThrow();

        //TODO

        return Converter.toGraduationResponse(graduationsModel);
    }

    public void deleteGraduation(String graduationId) {
        logger.info("Deleting graduation by id {}", graduationId);

        GraduationsModel graduationsModel = graduationRepository
                .findById(graduationId)
                .orElseThrow(() -> new ResourceNotFoundException("Graduation not found"));

        graduationRepository.deleteById(graduationId);
    }


}
