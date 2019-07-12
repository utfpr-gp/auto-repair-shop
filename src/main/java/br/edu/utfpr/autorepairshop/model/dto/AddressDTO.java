package br.edu.utfpr.autorepairshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class AddressDTO {
	private Long id;
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
	
	public AddressDTO(String street, String city, String state, String cep, String number) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.number = number;
	}
}
