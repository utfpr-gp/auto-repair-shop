package br.edu.utfpr.autorepairshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Address address;
	@OneToOne
	private Credential credential;
	@Column(name = "date_birth")
	private Date dateBirth;
	private String name;
	private String telephone;

	public Client(Address address, Credential credential, Date dateBirth, String name, String telephone) {
		this.address = address;
		this.credential = credential;
		this.dateBirth = dateBirth;
		this.name = name;
		this.telephone = telephone;
	}
}
