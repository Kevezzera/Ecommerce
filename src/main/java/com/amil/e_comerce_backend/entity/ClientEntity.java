package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.DTO.ClientDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "CLIENT")
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = (150))
    private String firstName;
    @Column(nullable = false, length = (150))
    private String lastName;
    @Column(nullable = false, length = (20))
    private String login;
    @Column(nullable = false, length = (11))
    private String cpf;
    @Column(nullable = false, length = (100))
    private String password;
    @Column(nullable = false, length = (20))
    private String cell;
    @Column(nullable = false, length = (20))
    private LocalDate nascimento;

    private ClientEntity (ClientDTO client){
        BeanUtils.copyProperties(client, this);
    }

    //LIGACOES
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendasEntity> vendas;
}
