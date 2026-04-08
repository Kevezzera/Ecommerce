package com.amil.e_comerce_backend.controller;

import com.amil.e_comerce_backend.dto.VendasDTO;
import com.amil.e_comerce_backend.repository.VendasRepository;
import com.amil.e_comerce_backend.servics.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vendas")
@RestController
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @PostMapping
    public void insert(@RequestBody VendasDTO vendasDTO){
        vendasService.insert(vendasDTO);
    }

    @GetMapping("/buscar_registros/{id}")
    public List<VendasDTO> findVendasClient(@PathVariable Long id){

        return vendasService.findByregistros(id);
    }

}
