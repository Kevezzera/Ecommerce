package com.amil.e_comerce_backend.controller;


import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.dto.ProductDTO;
import com.amil.e_comerce_backend.servics.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void insert(@RequestBody ProductDTO productDTO){
        productService.insert(productDTO);
    }

    @GetMapping
    public List<ProductDTO> findAllClient() {
        return productService.findAll();
    }

    @PutMapping
    public ProductDTO editClient(@RequestBody ProductDTO productDTO) {
        return productService.edit(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public ProductDTO findByIdClient(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/findByName")
    public List<ProductDTO> findByNameClient(@RequestParam String firstName){
        return productService.findByName(firstName);
    }

}
