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
@Table(name = "mechanical_workshops")
@NoArgsConstructor
@Data
public class MechanicalWorkshops {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_workshop")
	private Long idworkshop;

	@JoinColumn(name = "id_adress")
	@OneToOne
	private Adress idAdress;

	private String name;
	private String cnpj;
	private String telephone;
	private String image;

	public MechanicalWorkshops(Long idworkshop, Adress idAdress, String name, String cnpj, String telephone,
			String image) {
		super();
		this.idworkshop = idworkshop;
		this.idAdress = idAdress;
		this.name = name;
		this.cnpj = cnpj;
		this.telephone = telephone;
		this.image = image;
	}
}
