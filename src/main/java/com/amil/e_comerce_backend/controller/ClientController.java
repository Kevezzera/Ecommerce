package com.amil.e_comerce_backend.controller;

import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.servics.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void insert(@RequestBody ClientDTO client){
        clientService.insert(client);
    }

}
