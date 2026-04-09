package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String codgo;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double value;

    @Column(nullable = false)
    private double resale_value;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate entrada;

    public ProductEntity(ProductDTO product){
            BeanUtils.copyProperties(product, this);

    }

}

