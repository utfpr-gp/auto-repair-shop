package br.edu.utfpr.autorepairshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="addresses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String city;
	private String state;
	private String cep;
	private String number;
	
	public Address(String street, String city, String state, String cep, String number) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.number = number;
	}
}
