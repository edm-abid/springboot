package com.example.client.web;

import com.example.client.dto.ClientRequestDto;
import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class ClientGraphql {
    @Autowired
    ClientRepository clientRepository;
    @QueryMapping
    public List<Client> listerClient(){
        return clientRepository.findAll();
    }
    @QueryMapping
    public Client clientById(@PathVariable Long id){
        return clientRepository.findById(id).get();
    }
    public Client addClient(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientRequestDto, client);
        return clientRepository.save(client);
    }

}
