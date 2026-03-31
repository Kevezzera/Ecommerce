package com.amil.e_comerce_backend.repository;

import com.amil.e_comerce_backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findByNameContaining(String name);
}
