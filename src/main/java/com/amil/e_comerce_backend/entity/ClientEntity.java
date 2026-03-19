package com.amil.e_comerce_backend.entity;

import com.amil.e_comerce_backend.DTO.ClientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "CLIENT")
@Entity
public class ClientEntity {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String cpf;
    private String password;
    private String cell;
    private Date nascimento;

    private ClientEntity (ClientDTO client){
        BeanUtils.copyProperties(client, this);
    }
}
