package com.amil.e_comerce_backend.controller;


import com.amil.e_comerce_backend.dto.ClientDTO;
import com.amil.e_comerce_backend.dto.ProductDTO;
import com.amil.e_comerce_backend.servics.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Produtos", description = "Gerenciamento de produtos")
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Cadastrar produtos", description = "Cadastra um novo pedido na base de dados.")
    @PostMapping("/cadastro")
    public void insert(@RequestBody ProductDTO productDTO){
        productService.insert(productDTO);
    }

    @Operation(summary = "Listar produtos.", description = "Lista todos os produtos da base de dados.")
    @GetMapping("/listar")
    public List<ProductDTO> findAllClient() {
        return productService.findAll();
    }

    @Operation(summary = "Editar produtos.", description = "Edita um produto ja existente na base de dados.")
    @PutMapping("/editar")
    public ProductDTO editClient(@RequestBody ProductDTO productDTO) {
        return productService.edit(productDTO);
    }

    @Operation(summary = "Delete produtos.", description = "Deleta um produtos da base de dados com base no sei ID.")
    @DeleteMapping("/deletar/{id}")
    public void deleteClient(@PathVariable Long id) {
        productService.delete(id);
    }

    @Operation(summary = "Buscar por Id.", description = "Busca um produto da base de dados com base no seu Id.")
    @GetMapping("/buscarId/{id}")
    public ProductDTO findByIdClient(@PathVariable Long id) {
        return productService.findById(id);
    }

    @Operation(summary = "Buscar pelo nome.", description = "Busca um produto dad base de dados com base no seu nome.")
    @GetMapping("/buscarNome")
    public List<ProductDTO> findByNameClient(@RequestParam String firstName){
        return productService.findByName(firstName);
    }

}
