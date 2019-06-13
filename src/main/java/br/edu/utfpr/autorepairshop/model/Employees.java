package br.edu.utfpr.autorepairshop.model;

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
@Table(name = "employees")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Employees {
	@Id
	@Column(name = "id_employees")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmployees;

	@JoinColumn(name = "id_credentials")
	@OneToOne
	private Credentials idCredentials;

	@Column(name = "id_workshop")
	private Long idWorkshop;

	@Column(name = "id_adress")
	private Long idAdress;

	private String name;
	private String telephone;

	public Employees(Long idEmployees, Credentials idCredentials, Long idWorkshop, Long idAdress, String name,
			String telephone) {
		this.idEmployees = idEmployees;
		this.idCredentials = idCredentials;
		this.idWorkshop = idWorkshop;
		this.idAdress = idAdress;
		this.name = name;
		this.telephone = telephone;
	}
}
