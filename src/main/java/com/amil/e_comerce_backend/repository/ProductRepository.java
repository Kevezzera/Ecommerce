package com.amil.e_comerce_backend.repository;

import com.amil.e_comerce_backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findByNameContaining(String name);

    @Query("SELECT p FROM ProductEntity p " +
            "WHERE p.name LIKE :valor% " +
            "OR p.codgo LIKE :valor% " +
            "OR p.description LIKE :valor% ")
    List<ProductEntity> buscarPorQualquerAtributo(@Param("valor") String valor);

}
