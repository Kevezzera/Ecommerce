package com.amil.e_comerce_backend.controller;


import com.amil.e_comerce_backend.dto.ProductDTO;
import com.amil.e_comerce_backend.servics.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void insert(@RequestBody ProductDTO productDTO){
        productService.insert(productDTO);
    }
}
