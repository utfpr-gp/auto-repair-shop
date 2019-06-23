package br.edu.utfpr.autorepairshop.model.dto;

import br.edu.utfpr.autorepairshop.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {

    private Long id;

    @NotEmpty(message = "Informe a marca do veiculo.")
    private String brand;

    @NotEmpty(message = "Informe o modelo do veiculo.")
    private String model;

    private String color;

    @NotEmpty(message = "Informe a placa do veiculo.")
    private String placa;

    private String type;

    private byte[] image;

    private Client client;
}
