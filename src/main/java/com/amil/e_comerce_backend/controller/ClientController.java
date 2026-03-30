package com.amil.e_comerce_backend.controller;


import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.servics.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void insert(@RequestBody ClientDTO client){
        clientService.insert(client);
    }

    @GetMapping
    public List<ClientDTO> listar(){
        return clientService.listar();
    }

}
