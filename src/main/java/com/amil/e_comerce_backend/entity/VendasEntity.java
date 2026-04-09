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
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private LocalTime hora;
    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;


    public VendasEntity(VendasDTO vendasDTO){
        BeanUtils.copyProperties(vendasDTO, this);

        if(vendasDTO != null && vendasDTO.getProductDTO() != null){
            this.product = new ProductEntity(vendasDTO.getProductDTO());
        }

        if (vendasDTO != null && vendasDTO.getClientDTO() != null){
            this.client = new ClientEntity(vendasDTO.getClientDTO());
        }
    }



}
