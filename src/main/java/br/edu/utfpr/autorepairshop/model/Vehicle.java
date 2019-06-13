package br.edu.utfpr.autorepairshop.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicle")
	private Long idVehicle;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client idClient;

	private String brand;
	private String model;
	private String color;
	private String placa;
	private String type;
	private String image;

	public Vehicle(Long idVehicle, Client idClient, String brand, String model, String color, String placa, String type,
			String image) {
		this.idVehicle = idVehicle;
		this.idClient = idClient;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.placa = placa;
		this.type = type;
		this.image = image;
	}
}
