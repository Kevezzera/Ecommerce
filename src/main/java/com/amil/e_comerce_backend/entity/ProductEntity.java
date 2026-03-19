package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_ENTITY")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME", nullable = false, length = (100))
    private String name;
    @Column(name = "QUANTITY", nullable = false, length = (100))
    private int quantity;
    @Column(name = "VALUE", nullable = false, length = (100))
    private double value;
    @Column(name = "RESALE", nullable = false, length = (100))
    private double resaleValue;
    @Column(name = "DESCRIPTION", nullable = false, length = (300))
    private String description;

    public ProductEntity(ProductDTO product){
            BeanUtils.copyProperties(product, this);
}

// LIGACOES //
    @OneToMany(mappedBy = "PRODUCT_ENTITY", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendasEntity> vendas;
}

