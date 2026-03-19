package com.amil.e_comerce_backend.repository;

import com.amil.e_comerce_backend.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
