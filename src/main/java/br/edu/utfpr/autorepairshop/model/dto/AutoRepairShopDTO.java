package br.edu.utfpr.autorepairshop.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.edu.utfpr.autorepairshop.model.Credential;
import org.springframework.web.multipart.MultipartFile;

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
	@NotEmpty(message = "O Cnpj da Oficina é obrigatório")
	private String cnpj;
	
	@NotEmpty(message = "O Telefone da Oficina é obrigatório")
	//@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message = "Telefone em formato inválido")
	private String telephone;
	
	private String image;
	
	//Atributos address DTO
	private String street;
	private String city;
	private String state;
	private String cep;
	private String number;
	
	private MultipartFile file;
	
	private AddressDTO address;
	private Credential manager;
	
	public void convertAddress(){
		address =  new AddressDTO(street,city, state, cep, number);
	}
}