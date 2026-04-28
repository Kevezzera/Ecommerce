package com.amil.e_comerce_backend.servics;

import com.amil.e_comerce_backend.dto.ProductDTO;
import com.amil.e_comerce_backend.dto.VendasDTO;
import com.amil.e_comerce_backend.entity.ProductEntity;
import com.amil.e_comerce_backend.entity.VendasEntity;
import com.amil.e_comerce_backend.repository.ProductRepository;
import com.amil.e_comerce_backend.repository.VendasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class VendasService {


    final private VendasRepository vendasRepository;
    final private ProductRepository productRepository;

    public VendasService(VendasRepository vendasRepository, ProductRepository productRepository) {
        this.vendasRepository = vendasRepository;
        this.productRepository = productRepository;
    }


    @Transactional
    public void insert(VendasDTO vendasDTO){

        if (vendasDTO.getData() == null) {
            vendasDTO.setData(LocalDate.now());
        }
        if (vendasDTO.getHora() == null) {
            vendasDTO.setHora(LocalTime.now());
        }

        ProductEntity product = productRepository.findById(vendasDTO.getProductDTO().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setQuantity(product.getQuantity() - vendasDTO.getQuantProdut());
        productRepository.save(product);

        VendasEntity vendasEntity = new VendasEntity(vendasDTO);
        vendasRepository.save(vendasEntity);
    }

    public List<VendasDTO> findByregistros(Long id){
        Optional<VendasEntity> vendas = vendasRepository.findById(id);
        return  vendas.stream()
                .map(VendasDTO::new) // supondo construtor AgendaDto(AgendaEntity e)
                .toList();
    }

}
