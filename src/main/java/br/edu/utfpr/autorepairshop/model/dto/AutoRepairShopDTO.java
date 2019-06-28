package br.edu.utfpr.autorepairshop.model.dto;

import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AutoRepairShopDTO {
	private Long id;
	@NotEmpty(message = "O Nome da Oficina é obrigatório")
	private String name;
	private String cnpj;
	private String telephone;
	private String image;
	
	//Atributos address DTO
	private String street;
	private String city;
	private String state;
	private String cep;
	private String number;

	private AddressDTO addressDTO;
}