package br.edu.utfpr.autorepairshop.model.dto;

import br.edu.utfpr.autorepairshop.model.AutoRepairShop;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MaintenanceDTO {

	private Long id;

	private Long registration;

	private Vehicle vehicle;

	private Client client;
	
	private Employee employee;

	private AutoRepairShop AutoRepairShop;
	
	@NotNull(message = "Data é obrigatória.")
	private Date date;

	@NotEmpty(message = "Hora é obrigatória.")
	@Pattern(regexp = "([0-9]{2}:[0-9]{2} AM|[0-9]{2}:[0-9]{2} PM)", message = "Horário deve estar no formato HH:MM AM")
	private String hour;

    @NotEmpty(message = "Descrição deve estar presente.")
	private String description;

    @NotNull(message = "Preço total deve estar presente.")
    @DecimalMin(value = "0.0", message = "Preço total deve ser maior que 0.")
	private Long totalPrice;
    
    @NotNull(message = "Preço da mão-de-obra deve estar presente.")
    @DecimalMin(value = "0.0", message = "Preço da mão-de-obra deve ser maior que 0.")
	private Long priceHandWork;
    
    @NotNull(message = "Preço das partes deve estar presente.")
    @DecimalMin(value = "0.0", message = "Preço das partes deve ser maior que 0.")
	private Long priceParts;
}
