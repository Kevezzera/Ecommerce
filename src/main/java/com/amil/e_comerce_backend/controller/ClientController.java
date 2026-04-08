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

    @PostMapping("/insertClient")
    public void insertClient(@RequestBody ClientDTO client) {
        clientService.insert(client);
    }

    @GetMapping("/finfAllClient")
    public List<ClientDTO> findAllClient() {
        return clientService.findByAll();
    }

    @PutMapping("aditClient")
    public ClientDTO editClient(@RequestBody ClientDTO clientDTO) {
        return clientService.edit(clientDTO);
    }

    @DeleteMapping("/deliteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }

    @GetMapping("/findByIdClient/{id}")
    public ClientDTO findByIdClient(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/findByNameClient/findByName")
    public List<ClientDTO> findByNameClient(@RequestParam String firstName){
        return clientService.findByName(firstName);
    }

}
