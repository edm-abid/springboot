package com.example.client.mapper;

import com.example.client.dto.ClientRequestDto;
import com.example.client.dto.ClientResponseDto;
import com.example.client.entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperInterImpl implements ClientMapperInter {
    @Override
    public Client fromReqDto2Client(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client.setFullName(clientRequestDto.getFullName());
        client.setEmail(clientRequestDto.getEmail());
        return client;

    }

    @Override
    public ClientResponseDto fromRepDto2Client(Client client) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        BeanUtils.copyProperties(client,clientResponseDto);

        return clientResponseDto;

    }
}
