package com.jonatas.graduation_control_api.controller;

import com.jonatas.graduation_control_api.dto.PlansRequest;
import com.jonatas.graduation_control_api.dto.PlansResponse;
import com.jonatas.graduation_control_api.service.PlansService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/plans")
public class PlansController {

    @Autowired
    PlansService plansService;

    private final Logger logger = getLogger(ClientController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlansResponse> getAllPlans() {
        logger.info("Listing all plans");

        return plansService.getAllPlans();
    }

    @GetMapping("/{planId}")
    @ResponseStatus(HttpStatus.OK)
    public PlansResponse getPlanById(@PathVariable Integer planId) {
        logger.info("Getting plan by id {}", planId);

        return plansService.getPlanById(planId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlansResponse createPlan(@RequestBody PlansRequest planRequest) {
        logger.info("Creating a new plan");

        return plansService.createPlan(planRequest);
    }

    @PutMapping("/{planId}")
    @ResponseStatus(HttpStatus.OK)
    public PlansResponse updatePlan(
            @PathVariable Integer planId,
            @RequestBody PlansResponse planRequest) {
        logger.info("Updating plan with id {}", planId);

        return plansService.updatePlan(planId, planRequest);

    }



    @DeleteMapping("/{planId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlan(@PathVariable Integer planId) {
        logger.info("Deleting plan by id {}", planId);
        plansService.deletePlan(planId);
    }

}
