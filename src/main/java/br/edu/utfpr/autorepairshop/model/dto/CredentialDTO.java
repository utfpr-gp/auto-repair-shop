package br.edu.utfpr.autorepairshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class CredentialDTO {

    private Long id;

    @Email(message = "Insira um email válido.")
    @NotEmpty(message = "Por favor informe o email.")
    private String email;

    private String password;

    private String passwordConfirmation;

    private String role;
}
