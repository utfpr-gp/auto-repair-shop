package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Maintenance;
import br.edu.utfpr.autorepairshop.model.dto.MaintenanceDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceMapper {

    @Autowired
    private ModelMapper mapper;

    public MaintenanceDTO toDto(Maintenance entity) {
    	MaintenanceDTO dto = mapper.map(entity, MaintenanceDTO.class);
        return dto;
    }

    public MaintenanceDTO toResponseDto(Maintenance entity) {
    	MaintenanceDTO dto = mapper.map(entity, MaintenanceDTO.class);
        dto.setRegistration(entity.getId());
        return dto;
    }

    public Maintenance toEntity(MaintenanceDTO dto) throws ParseException {
    	Maintenance entity = mapper.map(dto, Maintenance.class);
        return entity;
    }
}
