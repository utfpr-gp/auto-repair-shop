package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.dto.ClientDataDTO;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapper {
    @Autowired
    private ModelMapper mapper;

    public CredentialDTO toDto(Credential credential){
        CredentialDTO dto = mapper.map(credential, CredentialDTO.class);
        return dto;
    }

    public Credential toEntity(CredentialDTO dto){
        Credential credential = mapper.map(dto, Credential.class);
        return credential;
    }
}
