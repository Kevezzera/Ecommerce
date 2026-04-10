package com.amil.e_comerce_backend.controller;

import com.amil.e_comerce_backend.dto.VendasDTO;
import com.amil.e_comerce_backend.repository.VendasRepository;
import com.amil.e_comerce_backend.servics.VendasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vendas", description = "Gerenciamento do registro de vendas")
@RequestMapping("/vendas")
@RestController
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @PostMapping
    @Operation(summary = "Registrar", description = "Registre uama nova venda.")
    public void insert(@RequestBody VendasDTO vendasDTO){
        vendasService.insert(vendasDTO);
    }

    @GetMapping("/buscar_registros/{id}")
    @Operation(summary = "Registro por cliente", description = "Busca registros de vendas ligadas a um cliente.")
    public List<VendasDTO> findVendasClient(@PathVariable Long id){
        return vendasService.findByregistros(id);
    }

}
