package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.VehicleDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    @Autowired
    private ModelMapper mapper;

    public VehicleDTO toDto(Vehicle entity) {
        VehicleDTO dto = mapper.map(entity, VehicleDTO.class);
        return dto;
    }

    public VehicleDTO toResponseDto(Vehicle entity) {
        VehicleDTO dto = mapper.map(entity, VehicleDTO.class);
        dto.setRegistration(entity.getId());
        return dto;
    }

    public Vehicle toEntity(VehicleDTO dto) throws ParseException {
        Vehicle entity = mapper.map(dto, Vehicle.class);
        return entity;
    }
}
