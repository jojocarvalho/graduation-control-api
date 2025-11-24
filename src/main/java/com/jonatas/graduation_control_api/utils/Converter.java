package com.jonatas.graduation_control_api.utils;

import com.jonatas.graduation_control_api.dto.*;
import com.jonatas.graduation_control_api.model.ClientModel;
import com.jonatas.graduation_control_api.model.EnrollmentsModel;
import com.jonatas.graduation_control_api.model.PlansModel;
import com.jonatas.graduation_control_api.repository.ClientRepository;
import com.jonatas.graduation_control_api.repository.PlansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Converter {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PlansRepository plansRepository;

    public static ClientModel toClientModel(ClientRequest clientRequest) {
        ClientModel clientModel = new ClientModel();
        clientModel.setClientId("CLIENT_" + UUID.randomUUID().toString().toUpperCase());
        clientModel.setCpf(clientRequest.getCpf());
        clientModel.setName(clientRequest.getName());
        clientModel.setAge(clientRequest.getAge());
        clientModel.setAddress(clientRequest.getAddress());
        return clientModel;
    }

    public static ClientResponse toClientResponse(ClientModel clientModel) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setClientId(clientModel.getClientId());
        clientResponse.setCpf(clientModel.getCpf());
        clientResponse.setName(clientModel.getName());
        clientResponse.setAge(clientModel.getAge());
        clientResponse.setAddress(clientModel.getAddress());
        return clientResponse;
    }

    public static PlansModel toPlansModel(PlansRequest plansRequest) {
        PlansModel plansModel = new PlansModel();
        plansModel.setName(plansRequest.getName());
        plansModel.setPrice(plansRequest.getPrice());
        return plansModel;
    }

    public static PlansResponse toPlansResponse(PlansModel plansModel) {
        PlansResponse plansResponse = new PlansResponse();
        plansResponse.setPlansId(plansModel.getPlansId());
        plansResponse.setName(plansModel.getName());
        plansResponse.setPrice(plansModel.getPrice());
        return plansResponse;
    }

    public static EnrollmentsModel toEnrollmentsModel(EnrollmentsRequest enrollmentsRequest){
        EnrollmentsModel enrollmentsModel = new EnrollmentsModel();

        enrollmentsModel.setEnrollmenstId("ENROLLMENT_" + UUID.randomUUID().toString().toUpperCase());
        enrollmentsModel.setStudentCode("");
        enrollmentsModel.setStartTime(LocalDateTime.now());
        enrollmentsModel.setClient();
        enrollmentsModel.setPlan();
        return enrollmentsModel;
    }

    public static EnrollmentsResponse toEnrollmentResponse(EnrollmentsModel model) {
        EnrollmentsResponse response = new EnrollmentsResponse();
        response.setClientId(model.getClient().getClientId());
        response.setPlansId(model.getPlan().getPlansId());
        response.setStudentCode(model.getStudentCode());
        response.setStartTime(model.getStartTime());
        return response;
    }

}
