package com.jonatas.graduation_control_api.utils;

import com.jonatas.graduation_control_api.dto.ClientRequest;
import com.jonatas.graduation_control_api.dto.ClientResponse;
import com.jonatas.graduation_control_api.model.ClientModel;

import java.util.UUID;

public class Converter {

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

}
