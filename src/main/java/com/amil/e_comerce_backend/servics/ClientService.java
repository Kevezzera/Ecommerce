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

    public List<ClientDTO> listar(){
        List<ClientEntity> cliente = clientRepository.findAll();
        return cliente.stream().map(ClientDTO::new).toList();
    }

    public ClientDTO edit(ClientDTO clientDTO){
        ClientEntity client = new ClientEntity(clientDTO);
        return new ClientDTO(clientRepository.save(client));
    }

    public void delite(Long id){
        ClientEntity client = clientRepository.findById(id).get();
        clientRepository.delete(client);
    }

//    public String delete(long id){
//        this.carroRepository.deleteById(id);
//        return "Carro deletado";
//    }

}
