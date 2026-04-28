package com.amil.e_comerce_backend.dto;

import com.amil.e_comerce_backend.entity.VendasEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class VendasDTO {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String status;
    private int quantProdut;
    private ClientDTO clientDTO;
    private ProductDTO productDTO;


    public VendasDTO(VendasEntity vendasEntity){
        BeanUtils.copyProperties(vendasEntity, this);
        if(vendasEntity != null && vendasEntity.getClient() != null){
            this.clientDTO = new ClientDTO(vendasEntity.getClient());
        }

        if (vendasEntity != null && vendasEntity.getProduct() != null){
            this.productDTO = new ProductDTO(vendasEntity.getProduct());
        }
    }

}
