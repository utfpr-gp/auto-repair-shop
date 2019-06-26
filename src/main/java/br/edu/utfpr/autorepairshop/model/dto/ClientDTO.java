package br.edu.utfpr.autorepairshop.model.dto;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDTO {

    private Long id;

    @Pattern(regexp = "^(\\s?[A-ZÀ-Ú][a-zà-ú]+)+(\\s[a-zà-ú]*)?(\\s[A-ZÀ-Ú][a-zà-ú]*)+", message = "Insira o seu nome completo iniciando com letras maíusculas.")
    @NotEmpty(message = "Nome deve ser preenchido!")
    private String name;

//    @NotEmpty(message = "Por favor informe o cep.")
//    private String cep;
//
//    @NotEmpty(message = "Por favor informe o estado.")
//    private String state;
//
//    @NotEmpty(message = "Por favor informe a cidade.")
//    private String city;
//
//    @NotEmpty(message = "Por favor informa a rua.")
//    private String street;
//
//    @NotEmpty(message = "Por favor informe o numero da residencia.")
//    private String number;

   // private Address address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotEmpty(message = "Por favor informe o telefone.")
    private String telephone;

   // private Credential credential;

//    @Email(message = "Insira um email válido.")
//    @NotEmpty(message = "Por favor informe o email.")
//    private String email;
//
//    @NotEmpty(message = "Password não pode estar vazio.")
//    private String password;
}
