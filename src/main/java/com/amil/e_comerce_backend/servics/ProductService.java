package com.amil.e_comerce_backend.servics;

import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.dto.ProductDTO;
import com.amil.e_comerce_backend.entity.ClientEntity;
import com.amil.e_comerce_backend.entity.ProductEntity;
import com.amil.e_comerce_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void insert(ProductDTO productDTO){
        productDTO.setEntrada(LocalDate.now());
        ProductEntity productEntity = new ProductEntity(productDTO);
        productRepository.save(productEntity);
    }

    public List<ProductDTO> findAll(){
        List<ProductEntity> product = productRepository.findAll();
        return product.stream().map(ProductDTO::new).toList();
    }

    public ProductDTO edit(ProductDTO productDTO){
        ProductEntity product = new ProductEntity(productDTO);
        return new ProductDTO(productRepository.save(product));
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public ProductDTO findById(Long id){
        ProductEntity product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }

    public List<ProductDTO> findByName(String name){
        List<ProductEntity> product = productRepository.findByNameContaining(name);
        return product.stream().map(ProductDTO::new).toList();
    }

    public List<ProductDTO> findByAtribut(String name){
        List<ProductEntity> product = productRepository.buscarPorQualquerAtributo(name);
        return product.stream().map(ProductDTO::new).toList();
    }

}
