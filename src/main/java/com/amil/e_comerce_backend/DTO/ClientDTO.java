package com.amil.e_comerce_backend.DTO;

import com.amil.e_comerce_backend.entity.ClientEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String cpf;
    private String password;
    private String cell;
    private Date nascimento;

    private ClientDTO (ClientEntity client){
        BeanUtils.copyProperties(client, this);
    }
}
