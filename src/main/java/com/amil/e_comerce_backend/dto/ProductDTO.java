package com.amil.e_comerce_backend.dto;

import com.amil.e_comerce_backend.entity.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String codgo;

    @NotNull
    private int quantity;
    private double value;
    private double resale_value;
    private String description;
    private LocalDate entrada;

    public ProductDTO(ProductEntity product){
        BeanUtils.copyProperties(product, this);
    }

}