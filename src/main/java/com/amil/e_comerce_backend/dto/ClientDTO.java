package com.amil.e_comerce_backend.dto;

import com.amil.e_comerce_backend.entity.ClientEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {
    private Long id;

    @NotNull
    private String firstName;
    private String lastName;
    private String login;
    private String cpf;
    private String password;
    private String cell;
    private String nascimento;

    public ClientDTO (ClientEntity client){
        BeanUtils.copyProperties(client, this);
    }
}
