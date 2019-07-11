package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDataDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ClientMapper {

    @Autowired
    private ModelMapper mapper;

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("dd/MM/yyyy");

    public ClientDataDTO toResponseDto(Client entity){
        ClientDataDTO clientDataDTO = mapper.map(entity, ClientDataDTO.class);
        clientDataDTO.setBirthDate(this.dateFormat.format(entity.getBirthDate()));


        return clientDataDTO;
    }

    public Client toEntity(ClientDataDTO clientDataDTO){
        Client client = mapper.map(clientDataDTO, Client.class);
        return client;
    }


}
