package br.edu.utfpr.autorepairshop.model;

import java.sql.Time;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service")
@Data
@NoArgsConstructor
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_service")
	private Long idService;

	@JoinColumn(name = "id_client")
	@ManyToOne
	private Client idClient;

	@JoinColumn(name = "id_func_mechanical")
	@ManyToOne
	private Employees idFuncMechanical;

	@JoinColumn(name = "id_workshop")
	@ManyToOne
	private MechanicalWorkshops idWorkshop;

	@JoinColumn(name = "vehicle")
	@ManyToOne
	private Vehicle idVehicle;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "price_hand_work")
	private Double priceHandWork;

	// Inicialmente a oficina apenas irá ter uma descrição das peças e custos, porém
	// no banco será
	// implementado a modelagem das peças para uma futura atualização.
	@Column(name = "price_parts")
	private String priceParts;

	private Date date;
	private Time hour;
	private String description;
	
	public Service(Long idService, Client idClient, Employees idFuncMechanical, MechanicalWorkshops idWorkshop,
			Vehicle idVehicle, Double totalPrice, Double priceHandWork, String priceParts, Date date, Time hour,
			String description) {
		this.idService = idService;
		this.idClient = idClient;
		this.idFuncMechanical = idFuncMechanical;
		this.idWorkshop = idWorkshop;
		this.idVehicle = idVehicle;
		this.totalPrice = totalPrice;
		this.priceHandWork = priceHandWork;
		this.priceParts = priceParts;
		this.date = date;
		this.hour = hour;
		this.description = description;
	}
}
