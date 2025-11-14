package com.jonatas.graduation_control_api.controller;

import com.jonatas.graduation_control_api.dto.ClientRequest;
import com.jonatas.graduation_control_api.dto.ClientResponse;
import com.jonatas.graduation_control_api.model.ClientModel;
import com.jonatas.graduation_control_api.service.ClientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    private final Logger logger = getLogger(ClientController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponse> getAllClients() {
        logger.info("Listing all clients");

        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse getClientById(@PathVariable String clientId) {
        logger.info("Getting client by id {}", clientId);

        return clientService.getClientById(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse createClient(@Valid @RequestBody ClientRequest clientRequest) {
        logger.info("Creating a new client");

        return clientService.createClient(clientRequest);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable String clientId) {
        logger.info("Deleting client by id {}", clientId);

        clientService.deleteClient(clientId);
    }
}
