package br.edu.utfpr.autorepairshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Credential credential;
	@JoinColumn(name = "auto_repair_shop")
	@ManyToOne
	private AutoRepairShop autoRepairShop;
	@OneToOne
	private Address adress;
	private String name;
	private String telephone;

	public Employee(Credential credential, AutoRepairShop autoRepairShop, Address adress, String name,
			String telephone) {
		this.credential = credential;
		this.autoRepairShop = autoRepairShop;
		this.adress = adress;
		this.name = name;
		this.telephone = telephone;
	}
}
