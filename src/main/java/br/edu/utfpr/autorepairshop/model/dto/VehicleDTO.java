package br.edu.utfpr.autorepairshop.model.dto;

import br.edu.utfpr.autorepairshop.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {

	private Long id;
	
    private Long registration;

    private Client client;

    @NotEmpty(message = "A marca é obrigatório")
    private String brand;

    @NotEmpty(message = "O modelo é obrigatório.")
    private String model;
    //Descomentar quando tiver mascara
    //@Pattern(regexp = "([A-Z]{3}-?\\d[A-Z0-9]\\d{2})", message = "Placa em formato inválido")
    @NotEmpty(message = "Placa é obrigatório.")
    private String placa;

    @NotEmpty(message = "Cor é obrigatório.")
    private String color;

    @NotEmpty(message = "Tipo é obrigatório.")
    private String type;

    private String image;

    private MultipartFile file;
}
