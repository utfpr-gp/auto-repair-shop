package br.edu.utfpr.autorepairshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clients")
@Data
@NoArgsConstructor
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long idClient;
	
	@JoinColumn(name = "id_adress")
	@OneToOne
	private Adress idAdress;
	
	@JoinColumn(name = "id_credentials")
	@OneToOne
	private Credentials idCredentials;
	
	@Column(name = "data_birth")
	private Date dataBirth;
	
	private String name;
	private String telephone;

	public Client(Long idClient, Adress idAdress, Credentials idCredentials, Date dataBirth, String name, String telephone) {
		this.idClient = idClient;
		this.idAdress = idAdress;
		this.idCredentials = idCredentials;
		this.dataBirth = dataBirth;
		this.name = name;
		this.telephone = telephone;
	}
}
