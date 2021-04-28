package br.com.ericpinto.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;
}
