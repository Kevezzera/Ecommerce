package com.amil.e_comerce_backend.servics;

import com.amil.e_comerce_backend.dto.ProductDTO;
import com.amil.e_comerce_backend.entity.ProductEntity;
import com.amil.e_comerce_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void insert(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity(productDTO);
        productRepository.save(productEntity);
    }

}
