package br.edu.utfpr.autorepairshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class AddressDTO {
	private Long id;
	private String street;
	private String city;
	private String state;
	private String cep;
	private String number;
	
	public AddressDTO(String street, String city, String state, String cep, String number) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.number = number;
	}
}
