package br.edu.utfpr.autorepairshop.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.edu.utfpr.autorepairshop.security.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CredentialDTO {

    @NotEmpty(message = "O email não pode ser vazio.")
    @Email(message = "O email é inválido.")
    private String email;

    @NotEmpty(message = "A senha não pode ser vazia.")
    private String password;

    private String passwordConfirmation;

    private RoleEnum role;
}