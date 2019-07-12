package br.edu.utfpr.autorepairshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientToFormDTO {

    private Long id;

    @NotEmpty(message = "O nome do cliente é obrigatório")
    private String name;
}