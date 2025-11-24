package com.jonatas.graduation_control_api.service;

import com.jonatas.graduation_control_api.dto.PlansRequest;
import com.jonatas.graduation_control_api.dto.PlansResponse;
import com.jonatas.graduation_control_api.model.ClientModel;
import com.jonatas.graduation_control_api.model.PlansModel;
import com.jonatas.graduation_control_api.repository.ClientRepository;
import com.jonatas.graduation_control_api.repository.PlansRepository;
import com.jonatas.graduation_control_api.utils.Converter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class PlansService {

    @Autowired
    PlansRepository plansRepository;

    private final Logger logger = getLogger(PlansService.class);


    public List<PlansResponse> getAllPlans() {
        logger.info("Listing all plans");

        List<PlansModel> plans = plansRepository.findAll();

        return plans
                .stream()
                .map(Converter::toPlansResponse)
                .toList();
    }

    public PlansResponse getPlanById(String planId) {
        logger.info("Getting plan by id {}", planId);

        PlansModel plansModel = plansRepository.findById(planId).orElseThrow();

        return Converter.toPlansResponse(plansModel);
    }

    public PlansResponse createPlan(PlansRequest planRequest) {
        logger.info("Creating a new plan");

        PlansModel plansModel = Converter.toPlansModel(planRequest);

        plansRepository.save(plansModel);

        return Converter.toPlansResponse(plansModel);
    }

    public PlansResponse updatePlan(String planId, PlansResponse planRequest) {
        logger.info("Updating plan with id {}", planId);

        PlansModel plansModel = plansRepository
                .findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        plansModel.setName(planRequest.getName());
        plansModel.setPrice(planRequest.getPrice());


        plansRepository.save(plansModel);

        return Converter.toPlansResponse(plansModel);
    }

    public void deletePlan(String planId) {
        logger.info("Deleting plan by id {}", planId);

        plansRepository.deleteById(planId);
    }
}
