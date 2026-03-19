package com.amil.e_comerce_backend.DTO;

import com.amil.e_comerce_backend.entity.VendasEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private long id;
    private LocalDate data;
    private LocalTime hora;
    private String status;

    private VendasDTO(VendasEntity vendas){
        BeanUtils.copyProperties(vendas, this);
    }
}
