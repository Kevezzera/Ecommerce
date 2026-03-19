package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.dto.VendasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "VENDAS")
public class VendasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = (20))
    private LocalDate data;
    @Column(nullable = false, length = (20))
    private LocalTime hora;
    @Column(nullable = false, length = (50))
    private String status;

    public VendasEntity(VendasDTO vendas){
        BeanUtils.copyProperties(vendas, this);
    }

    //LIGACOES
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) //Coluna que recebe a chave estrngeira
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "vendas_id", nullable = false)
    private ClientEntity client;
}
