package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.DTO.VendasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "VENDAS_ENTITY")
public class VendasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = (20))
    private LocalDate data;
    @Column(nullable = false, length = (20))
    private LocalTime hora;
    @Column(nullable = false, length = (50))
    private String status;

    private VendasEntity(VendasDTO vendas){
        BeanUtils.copyProperties(vendas, this);
    }

    //LIGACOES
    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false) //Coluna que recebe a chave estrngeira
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity client;
}
