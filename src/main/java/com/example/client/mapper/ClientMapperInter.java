package com.example.client.mapper;

import com.example.client.dto.ClientRequestDto;
import com.example.client.dto.ClientResponseDto;
import com.example.client.entities.Client;

public interface ClientMapperInter {
    public Client fromReqDto2Client (ClientRequestDto clientRequestDto);

    public ClientResponseDto fromRepDto2Client (Client client);
}
