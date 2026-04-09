package com.amil.e_comerce_backend.controller;


import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.entity.ClientEntity;
import com.amil.e_comerce_backend.servics.ClientService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Cadastrar novo cliente", description = "Cadastre um novo cliente.")
    public ResponseEntity<String> insertClient(@RequestBody ClientDTO client) {
        try {
            String msg = clientService.insert(client);
            return new ResponseEntity<>(msg, HttpStatus.OK);

        }catch (Exception erro){
            return new ResponseEntity<String>("Dados incorretos! ", HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = "Exibir clientes.", description = "Exibe todos os clientes registrados.")
    @ResponseStatus
    @GetMapping("/findAllClient")
    public ResponseEntity<List<ClientDTO>> findAllClient() {
        try {
            List<ClientDTO> lista =  clientService.findByAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Editar cliente", description = "Edita dados do cliente.")
    @PutMapping("/editClient")
    public ResponseEntity<ClientDTO> editClient(@RequestBody ClientDTO clientDTO) {
        try {
             return new ResponseEntity<>(clientService.edit(clientDTO),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Deleta cliente", description = "Deleta cliente pelo Id.")
    @DeleteMapping("/deliteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            String msg = clientService.delete(id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar por Id", description = "Busca cliente pelo Id.")
    @GetMapping("/findByIdClient/{id}")
    public ResponseEntity<ClientDTO> findByIdClient(@PathVariable Long id) {
        try {
            ClientDTO client = clientService.findById(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar por nome", description = "Busca cliente pelo nome.")
    @GetMapping("/findByNameClient")
    public ResponseEntity<List<ClientDTO>> findByNameClient(@RequestParam String firstName){
        try {
            List<ClientDTO> clients = clientService.findByName(firstName);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
        }
    }
}
