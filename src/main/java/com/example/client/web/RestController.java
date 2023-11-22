package com.example.client.web;

import com.example.client.dto.ClientRequestDto;
import com.example.client.dto.ClientResponseDto;
import com.example.client.service.ClientServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    final private ClientServiceInter clientServiceInter;

    public RestController(ClientServiceInter clientServiceInter) {
        this.clientServiceInter = clientServiceInter;
    }
    @GetMapping("/clients")
    public List<ClientResponseDto> getClient(){
        return clientServiceInter.listerClient();
    }

    @GetMapping("/clients/{id}")
    public ClientResponseDto getClientId(@PathVariable Long id){
        return clientServiceInter.clientbyId(id);
    }
    @PostMapping("/clients")
    public void registerNewClient(@RequestBody ClientRequestDto clientRequestDto){
        clientServiceInter.ajouter(clientRequestDto);
    }
    @PutMapping("/client/{id}")
    public void updateClient(@PathVariable Long id,
                             @RequestBody ClientRequestDto c){

        clientServiceInter.update(id,c);
    }
    @DeleteMapping ("/client/{id}")
    public void deleteClient(@PathVariable Long id){
        clientServiceInter.supprimer(id);

    }

}
