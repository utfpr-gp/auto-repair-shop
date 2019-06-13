package br.edu.utfpr.autorepairshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="adresses")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Adress {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adress")
	private Long idAdress;
	
	private String street;
	private String city;
	private String state;
	private String cep;
	private int number;
	
	public Adress(Long idAdress, String street, String city, String state, String cep, int number) {
		this.idAdress = idAdress;
		this.street = street;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.number = number;
	}
}
