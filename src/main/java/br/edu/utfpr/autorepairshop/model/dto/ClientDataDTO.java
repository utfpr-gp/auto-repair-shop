package br.edu.utfpr.autorepairshop.model.dto;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDataDTO {

    private Long id;

    @Pattern(regexp = "^(\\s?[A-ZÀ-Ú][a-zà-ú]+)+(\\s[a-zà-ú]*)?(\\s[A-ZÀ-Ú][a-zà-ú]*)+", message = "Insira o seu nome completo iniciando com letras maíusculas.")
    @NotEmpty(message = "Nome deve ser preenchido!")
    private String name;

    @NotEmpty(message = "A data de nascimento é obrigatória")
//    @Pattern(regexp = "^([12]\\d|3[01])/(0\\d|1[012])/\\d{4}$",
//            message = "A data precisa estar formatada como dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String birthDate;

    @NotEmpty(message = "Por favor informe o telefone.")
    private String telephone;

    @NotEmpty(message = "Por favor informe o cep.")
    private String cep;

    @NotEmpty(message = "Por favor informe o estado.")
    private String state;

    @NotEmpty(message = "Por favor informe a cidade.")
    private String city;

    @NotEmpty(message = "Por favor informa a rua.")
    private String street;

    @NotEmpty(message = "Por favor informe o numero da residencia.")
    private String number;

    @Email(message = "Insira um email válido.")
    @NotEmpty(message = "Por favor informe o email.")
    private String email;

    private String password;

    private String passwordConfirmation;

    private String role;

    private Address address;

    private Credential credential;


    public Date getBirthDate() {
        Date d = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            d = format.parse(birthDate);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
