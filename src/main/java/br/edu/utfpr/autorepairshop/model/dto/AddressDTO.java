package br.edu.utfpr.autorepairshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
	private Long id;
	private String street;
	private String city;
	private String state;
	private String cep;
	private String number;
}
