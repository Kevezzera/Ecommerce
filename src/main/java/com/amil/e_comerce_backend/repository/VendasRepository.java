package com.amil.e_comerce_backend.repository;

import com.amil.e_comerce_backend.entity.VendasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendasRepository extends JpaRepository<VendasEntity, Long> {

    List<VendasEntity> findByClient_Id(Long id);
}
