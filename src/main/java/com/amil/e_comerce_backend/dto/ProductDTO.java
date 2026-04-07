package com.amil.e_comerce_backend.dto;

import com.amil.e_comerce_backend.entity.ProductEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private int quantity;
    private double value;
    private double resale_value;
    private String description;
//  private String entrada;

    public ProductDTO(ProductEntity product){
        BeanUtils.copyProperties(product, this);
    }

}