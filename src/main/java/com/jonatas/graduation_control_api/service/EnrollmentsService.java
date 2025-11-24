package com.jonatas.graduation_control_api.service;

import com.jonatas.graduation_control_api.dto.EnrollmentsRequest;
import com.jonatas.graduation_control_api.dto.EnrollmentsResponse;
import com.jonatas.graduation_control_api.exception.ResourceNotFoundException;
import com.jonatas.graduation_control_api.model.ClientModel;
import com.jonatas.graduation_control_api.model.EnrollmentsModel;
import com.jonatas.graduation_control_api.model.PlansModel;
import com.jonatas.graduation_control_api.repository.ClientRepository;
import com.jonatas.graduation_control_api.repository.EnrollmentsRepository;
import com.jonatas.graduation_control_api.repository.PlansRepository;
import com.jonatas.graduation_control_api.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import java.util.List;

import static com.jonatas.graduation_control_api.configuration.LoggerConfiguration.getLogger;

@Service
public class EnrollmentsService {

    @Autowired
    EnrollmentsRepository enrollmentsRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PlansRepository plansRepository;

    private final Logger logger = getLogger(EnrollmentsService.class);

    public List<EnrollmentsResponse> getAllEnrollments() {
        logger.info("Listing all enrollments");

        List<EnrollmentsModel> enrollments = enrollmentsRepository.findAll();

        return enrollments
                .stream()
                .map(Converter::toEnrollmentResponse)
                .toList();

    }

    public EnrollmentsResponse getEnrollmentById(String enrollmentId) {
        logger.info("Getting enrollment by id {}", enrollmentId);

        EnrollmentsModel enrollmentsModel = enrollmentsRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada"));

        return Converter.toEnrollmentResponse(enrollmentsModel);
    }

    public EnrollmentsResponse createEnrollment(EnrollmentsRequest enrollmentsRequest){
        logger.info("Creating a new enrollment");

        ClientModel client = clientRepository.findById(enrollmentsRequest.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        PlansModel plans = plansRepository.findById(enrollmentsRequest.getPlansId())
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));

        EnrollmentsModel enrollmentsModel = Converter.toEnrollmentsModel(enrollmentsRequest);

        enrollmentsRepository.save(enrollmentsModel);

        return Converter.toEnrollmentResponse(enrollmentsModel);
    }

    public EnrollmentsResponse updateEnrollment(String enrollmentId, EnrollmentsRequest enrollmentsRequest) {
        logger.info("Updating enrollment with id {}", enrollmentId);

        EnrollmentsModel enrollmentsModel = enrollmentsRepository
                .findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada"));

        ClientModel client = clientRepository.findById(enrollmentsRequest.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        PlansModel plans = plansRepository.findById(enrollmentsRequest.getPlansId())
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));

        enrollmentsRepository.save(enrollmentsModel);

        return Converter.toEnrollmentResponse(enrollmentsModel);
    }

    public void deleteEnrollment(String enrollmentId) {
        logger.info("Deleting enrollment by id {}", enrollmentId);

        enrollmentsRepository.deleteById(enrollmentId);
    }

}
