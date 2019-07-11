package br.edu.utfpr.autorepairshop.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auto_repair_shop")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AutoRepairShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	private String name;
	private String cnpj;
	private String telephone;
	private String image;
	@OneToOne(cascade = CascadeType.ALL)
	private Credential manager;

	public AutoRepairShop(Address adress, String name, String cnpj, String telephone,
			String image) {
		super();
		this.address = adress;
		this.name = name;
		this.cnpj = cnpj;
		this.telephone = telephone;
		this.image = image;
	}
}
