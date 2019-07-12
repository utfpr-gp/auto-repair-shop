package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDTO;
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

    public ClientDTO toResponseDto(Client entity){
        ClientDTO clientDTO = mapper.map(entity, ClientDTO.class);
        clientDTO.setBirthDate(this.dateFormat.format(entity.getBirthDate()));


        return clientDTO;
    }

    public Client toEntity(ClientDTO clientDTO){
        Client client = mapper.map(clientDTO, Client.class);
        return client;
    }


}
