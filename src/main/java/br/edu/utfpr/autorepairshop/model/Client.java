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
import lombok.Setter;

@Entity
@Table(name="client")
@Data
@Getter
@Setter
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long idClient;
	
	@Column(name = "id_adress")
	private Long idAdress;
	
	@Column(name = "id_credentials")
	private Long idCredentials;
	
	@Column(name = "data_birth")
	private Date dataBirth;
	
	private String name;
	private String telephone;

	public Client(Long id) {
		
	}
	
	public Client(Long idClient, Long idAdress, Long idCredentials, Date dataBirth, String name, String telephone) {
		this.idClient = idClient;
		this.idAdress = idAdress;
		this.idCredentials = idCredentials;
		this.dataBirth = dataBirth;
		this.name = name;
		this.telephone = telephone;
	}
}
