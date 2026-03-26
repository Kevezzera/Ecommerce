package com.amil.e_comerce_backend.controller;

import com.amil.e_comerce_backend.dto.VendasDTO;
import com.amil.e_comerce_backend.repository.VendasRepository;
import com.amil.e_comerce_backend.servics.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vendas")
@RestController
public class VendasController {

    @Autowired
    private VendasService vendasService;
    private VendasRepository vendasRepository;

    @PostMapping
    public void insert(@RequestBody VendasDTO vendasDTO){
        vendasService.insert(vendasDTO);
    }

}
