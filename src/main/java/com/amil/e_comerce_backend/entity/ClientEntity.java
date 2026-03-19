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
@Table(name = "CLIENT_ENTITY")
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = (150))
    private String firstName;
    @Column(name = "last_name",nullable = false, length = (150))
    private String lastName;
    @Column(name = "login", nullable = false, length = (20))
    private String login;
    @Column(name = "cpf", nullable = false, length = (11))
    private String cpf;
    @Column(name = "password",nullable = false, length = (100))
    private String password;
    @Column(name = "cell",nullable = false, length = (20))
    private String cell;
    @Column(name = "nascimento", nullable = false, length = (20))
    private LocalDate nascimento;

    private ClientEntity (ClientDTO client){
        BeanUtils.copyProperties(client, this);
    }

    //LIGACOES
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendasEntity> vendas;
}
