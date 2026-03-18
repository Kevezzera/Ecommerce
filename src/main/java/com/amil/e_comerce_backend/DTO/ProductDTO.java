package com.amil.e_comerce_backend.DTO;

import org.springframework.beans.BeanUtils;

public class ProductDTO {
    private long id;
    private String name;
    private double value;
    private double resaleValue;
    private String descripition;

    public ProductDTO(com.amil.e_comerce_backend.entity.ProductEntity product){
        BeanUtils.copyProperties(product, this);
    }


}