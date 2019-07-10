package br.edu.utfpr.autorepairshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "maintenances")
@Data
@NoArgsConstructor
public class Maintenance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Employee employee;
	@JoinColumn(name = "auto_repair_shop")
	@ManyToOne
	private AutoRepairShop autoRepairShop;
	@ManyToOne
	private Vehicle vehicle;
	@Column(name = "total_price")
	private Long totalPrice;
	@Column(name = "price_hand_work")
	private Long priceHandWork;
	private Date date;
	private String hour;
	private String description;

	// Inicialmente a oficina apenas irá ter uma descrição das peças e custos, porém
	// no banco será
	// implementado a modelagem das peças para uma futura atualização.
	@Column(name = "price_parts")
	private Long priceParts;

	public Maintenance(Client client, Employee employee, AutoRepairShop autoRepairShop,
			Vehicle vehicle, Long totalPrice, Long priceHandWork, Long priceParts, Date date, String hour,
			String description) {
		this.client = client;
		this.employee = employee;
		this.autoRepairShop = autoRepairShop;
		this.vehicle = vehicle;
		this.totalPrice = totalPrice;
		this.priceHandWork = priceHandWork;
		this.priceParts = priceParts;
		this.date = date;
		this.hour = hour;
		this.description = description;
	}
}
