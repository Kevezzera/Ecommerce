package com.amil.e_comerce_backend.servics;

import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.entity.ClientEntity;
import com.amil.e_comerce_backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void insert(ClientDTO clientDTO){
        ClientEntity client = new ClientEntity(clientDTO);
        clientRepository.save(client);
    }

    public List<ClientDTO> findByAll(){
        List<ClientEntity> client = clientRepository.findAll();
        return client.stream().map(ClientDTO::new).toList();
    }

    public ClientDTO edit(ClientDTO clientDTO){
        ClientEntity client = new ClientEntity(clientDTO);
        return new ClientDTO(clientRepository.save(client));
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public ClientDTO findById(Long id){
        ClientEntity client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    public List<ClientDTO> findByName(String firstName){
        List<ClientEntity> client = clientRepository.findByFirstNameContaining(firstName);
        return client.stream().map(ClientDTO::new).toList();
    }

//    cliente.stream()             // transforma a lista em um fluxo
//    .map(ClientDTO::new)         // para cada ClientEntity, cria um ClientDTO usando o construtor
//    .toList();                   // volta a ser uma lista de ClientDTO

}
