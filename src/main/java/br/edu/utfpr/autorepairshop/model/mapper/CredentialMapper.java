package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapper {
    @Autowired
    private ModelMapper mapper;


    public CredentialDTO toDto(Credential entity) {
        CredentialDTO dto = mapper.map(entity, CredentialDTO.class);
        return dto;
    }

    public Credential toEntity(CredentialDTO dto){
        Credential credential = mapper.map(dto, Credential.class);
        return credential;
    }
}
