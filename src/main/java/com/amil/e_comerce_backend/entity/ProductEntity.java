package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.dto.ProductDTO;
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
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = (100))
    private String name;
    @Column(nullable = false, length = (100))
    private int quantity;
    @Column(nullable = false, length = (100))
    private double value;
    @Column(nullable = false, length = (100))
    private double resaleValue;
    @Column(nullable = false, length = (300))
    private String description;

    public ProductEntity(ProductDTO product){
            BeanUtils.copyProperties(product, this);
}

// LIGACOES //
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendasEntity> vendas;
}

