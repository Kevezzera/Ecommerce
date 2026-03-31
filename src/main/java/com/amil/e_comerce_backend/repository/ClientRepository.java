package com.amil.e_comerce_backend.repository;

import com.amil.e_comerce_backend.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    public List<ClientEntity> findByFirstNameContaining(String firstName);





//        // Busca exata pelo primeiro nome
//        List<Person> findByFirstName(String firstName);
//
//        // Busca ignorando maiúsculas/minúsculas
//        List<Person> findByFirstNameIgnoreCase(String firstName);
//
//        // Busca por nomes que começam com...
//        List<Person> findByFirstNameStartingWith(String prefix);
//
//        // Busca por nomes que contenham...
//        List<Person> findByFirstNameContaining(String fragment);


}
