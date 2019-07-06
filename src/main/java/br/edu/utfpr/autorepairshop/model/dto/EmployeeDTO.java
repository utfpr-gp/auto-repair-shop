package br.edu.utfpr.autorepairshop.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

	private Long id;

	@Pattern(regexp = "^(\\s?[A-ZÀ-Ú][a-zà-ú]+)+(\\s[a-zà-ú]*)?(\\s[A-ZÀ-Ú][a-zà-ú]*)+", message = "Insira o seu nome completo iniciando com letras maíusculas.")
	@NotEmpty(message = "Nome deve ser preenchido!")
	private String name;
	
	@NotEmpty(message = "O Telefone da Oficina é obrigatório")
	@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message = "Telefone em formato inválido")	private String telephone;

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
	@NotEmpty(message = "Por favor informe um email.")
	private String email;
	
	@NotEmpty(message = "Por favor informe uma senha.")
	private String password;

	private String role;

	private Address address;

	private Credential credential;
}
