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
    public void insert(@RequestBody ClientDTO client){
        clientService.insert(client);
    }

    @GetMapping
    public List<ClientDTO> listar(){
        return clientService.listar();
    }

    @PutMapping
    public ClientDTO edit(@RequestBody ClientDTO clientDTO){
        return clientService.edit(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void delite(@PathVariable Long id){
        clientService.delite(id);
    }

    @GetMapping("/{id}")
    public ClientEntity buscarId(@PathVariable Long id){
        return clientService.buscarId(id);
    }

//    @GetMapping("/findById/{id}")
//    public ResponseEntity<Carro> findById(@PathVariable long id){
//        try {
//            Carro carro = this.carroService.findById(id);
//            return new ResponseEntity<>(carro, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping("/delet/{id}")
//    public ResponseEntity<String> delete(@PathVariable long id){
//        try {
//            String mensagem = this.carroService.delete(id);
//            return new ResponseEntity<>(mensagem, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
//        }
//    }

}
