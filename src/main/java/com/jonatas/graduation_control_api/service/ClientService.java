package com.jonatas.graduation_control_api.service;

import com.jonatas.graduation_control_api.dto.ClientRequest;
import com.jonatas.graduation_control_api.dto.ClientResponse;
import com.jonatas.graduation_control_api.model.ClientModel;
import com.jonatas.graduation_control_api.repository.ClientRepository;
import com.jonatas.graduation_control_api.utils.Converter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ClientService {


    @Autowired
    ClientRepository clientRepository;

    private final Logger logger = getLogger(ClientService.class);

    public List<ClientResponse> getAllClients() {
        logger.info("Listing all clients");

        List<ClientModel> clients = clientRepository.findAll();

        return clients
                .stream()
                .map(Converter::toClientResponse)
                .toList();
    }

    public ClientResponse getClientById(String clientId) {
        logger.info("Getting client by id {}", clientId);

        ClientModel clientModel = clientRepository.findById(clientId).orElseThrow();

        return Converter.toClientResponse(clientModel);
    }


    public ClientResponse createClient(ClientRequest clientRequest) {
        logger.info("Creating a new client");

        ClientModel clientModel = Converter.toClientModel(clientRequest);

        clientRepository.save(clientModel);

        return Converter.toClientResponse(clientModel);
    }

    public void deleteClient(String clientId) {
        logger.info("Deleting client by id {}", clientId);

//        TODO: verificar se o cliente existe antes de deletar

        clientRepository.deleteById(clientId);
    }


}
