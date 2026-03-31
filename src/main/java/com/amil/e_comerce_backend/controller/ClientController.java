package com.amil.e_comerce_backend.controller;


import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.entity.ClientEntity;
import com.amil.e_comerce_backend.servics.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void insertClient(@RequestBody ClientDTO client) {
        clientService.insert(client);
    }

    @GetMapping
    public List<ClientDTO> findAllClient() {
        return clientService.findByAll();
    }

    @PutMapping
    public ClientDTO editClient(@RequestBody ClientDTO clientDTO) {
        return clientService.edit(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }

    @GetMapping("/{id}")
    public ClientDTO findByIdClient(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/findByName")
    public List<ClientDTO> findByNameClient(@RequestParam String firstName){
        return clientService.findByName(firstName);
    }

}
