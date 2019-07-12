package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.AutoRepairShop;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.dto.ClientDataDTO;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
import br.edu.utfpr.autorepairshop.model.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapper {
    @Autowired
    private ModelMapper mapper;

    public Credential toEntity(ClientDataDTO clientDataDTO){
        Credential credential = mapper.map(clientDataDTO, Credential.class);
        return credential;
    }

    public CredentialDTO toDto(Credential entity) {
        CredentialDTO dto = mapper.map(entity, CredentialDTO.class);
        return dto;
    }

    public Credential toEntity(CredentialDTO dto){
        Credential credential = mapper.map(dto, Credential.class);
        return credential;
    }
}
