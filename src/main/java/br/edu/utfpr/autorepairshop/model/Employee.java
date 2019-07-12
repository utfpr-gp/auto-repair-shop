package br.edu.utfpr.autorepairshop.model;

import javax.persistence.CascadeType;
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
@NoArgsConstructor
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	private Credential credential;
	@JoinColumn(name = "auto_repair_shop")
	@ManyToOne
	private AutoRepairShop autoRepairShop;
	private String name;
	private String telephone;
	private String cellular;

	public Employee(Credential credential, AutoRepairShop autoRepairShop, Address address, String name, String cellular,
			String telephone) {
		this.credential = credential;
		this.autoRepairShop = autoRepairShop;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.cellular = cellular;
	}
}
