package com.example.client.service;

import com.example.client.dto.ClientRequestDto;
import com.example.client.dto.ClientResponseDto;

import java.util.List;

public interface ClientServiceInter {
    public void ajouter(ClientRequestDto clientRequestDto);
    public List<ClientResponseDto> listerClient();
    public ClientResponseDto clientbyId(Long id);
    public void update(Long id, ClientRequestDto clientRequestDto);
    public void supprimer(Long id);
}
