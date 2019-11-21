package br.edu.utfpr.autorepairshop.model.dto;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @NotEmpty(message = "A data de nascimento é obrigatória")
    @Pattern(regexp = "([0-3]\\d\\/[0,1]\\d\\/[0-2]\\d{3})", message = "A data precisa estar formatada como dd/MM/yyyy")
    private String birthDate;

    @NotEmpty(message = "O telefone é obrigatório")
	@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message = "Telefone em formato inválido")
    private String telephone;

    @Valid
    private AddressDTO addressDto;

    @Valid
    private CredentialDTO credentialDto;


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
