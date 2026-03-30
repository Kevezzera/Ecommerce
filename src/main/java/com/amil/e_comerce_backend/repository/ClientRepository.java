package com.amil.e_comerce_backend.repository;

import com.amil.e_comerce_backend.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

//    public List<ClientEntity> findByfirstName(String firstName);
    public List<ClientEntity> findByFirstName(String firstName);

}
