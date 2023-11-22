package com.example.client.service;

import com.example.client.dto.ClientRequestDto;
import com.example.client.dto.ClientResponseDto;
import com.example.client.entities.Client;
import com.example.client.mapper.ClientMapperInter;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientServiceInter{
    @Autowired
    final private ClientRepository clientRepository;
    @Autowired
    final private ClientMapperInter clientMapperInter;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapperInter clientMapperInter) {
        this.clientRepository = clientRepository;
        this.clientMapperInter = clientMapperInter;
    }


    @Override
    public void ajouter(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client = clientMapperInter.fromReqDto2Client(clientRequestDto);
        clientRepository.save(client);

    }

    @Override
    public List<ClientResponseDto> listerClient() {
        List<Client> liste = new ArrayList<Client>();
        liste= clientRepository.findAll();

        List<ClientResponseDto> liste2 = new ArrayList<ClientResponseDto>();
        for (Client client: liste){
            ClientResponseDto clientResponseDto = new ClientResponseDto();
            clientResponseDto=clientMapperInter.fromRepDto2Client(client);
            liste2.add(clientResponseDto);

        }

        return liste2;
    }

    @Override
    public ClientResponseDto clientbyId(Long id) {
        Client client = clientRepository.findById(id).get();
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto=clientMapperInter.fromRepDto2Client(client);
        return clientResponseDto;
    }

    @Override
    public void update(Long id, ClientRequestDto clientRequestDto) {

        Client client = clientRepository.findById(id).get();
        if(clientRequestDto.getFullName() != null) client.setFullName(clientRequestDto.getFullName());
        if(clientRequestDto.getEmail() != null) client.setEmail(clientRequestDto.getEmail());

        clientRepository.save(client);
    }

    @Override
    public void supprimer(Long id) {

        clientRepository.deleteById(id);
    }
}
