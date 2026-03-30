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

//    public List<UsuarioDto> listAll(){
//        List<UsuarioEntity> usuario = usuarioRepository.findAll();
//        return usuario.stream().map(UsuarioDto::new).toList();
//    }

}
