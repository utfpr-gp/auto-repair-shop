

package br.edu.utfpr.autorepairshop.model.dto;

import javax.validation.Valid;
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

	@Pattern(regexp = "^(\\s?[A-ZÀ-Ú][a-zà-ú]+)+(\\s[a-zà-ú]*)?(\\s[A-ZÀ-Ú][a-zà-ú]*)+", message = "Insira o seu nome completo com apenas as iniciais com letras maíusculas.")
	@NotEmpty(message = "Nome deve ser preenchido!")
	private String name;
	
	@NotEmpty(message = "O telefone é obrigatório")
	@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message = "Telefone em formato inválido")	
	private String telephone;
	
	@NotEmpty(message = "O celular é obrigatório")
	@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message = "Celular em formato inválido")	
	private String cellular;

	private String role;

	private AddressDTO addressDto;
	private CredentialDTO credentialDto;
}
