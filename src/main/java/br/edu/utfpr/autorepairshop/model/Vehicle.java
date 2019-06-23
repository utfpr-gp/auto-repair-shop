package br.edu.utfpr.autorepairshop.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Client client;
	private String brand;
	private String model;
	private String color;
	private String placa;
	private String type;
	private String image;

	public Vehicle(Client client, String brand, String model, String color, String placa, String type,
			String image) {
		this.client = client;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.placa = placa;
		this.type = type;
		this.image = image;
	}
}
