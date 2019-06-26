package br.edu.utfpr.autorepairshop.mapper;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    @Autowired
    private ModelMapper mapper;

    public Client toEntity(ClientDTO clientDTO){
        Client client = mapper.map(clientDTO, Client.class);
        return client;
    }


}
