package br.edu.utfpr.autorepairshop.model.mapper;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.autorepairshop.model.AutoRepairShop;
import br.edu.utfpr.autorepairshop.model.dto.AutoRepairShopDTO;


@Component
public class AutoRepairShopMapper {
    
	@Autowired
    private ModelMapper mapper;

    public AutoRepairShopDTO toDto(AutoRepairShop entity) {
    	AutoRepairShopDTO dto = mapper.map(entity, AutoRepairShopDTO.class);
        return dto;
    }
    
    public AutoRepairShopDTO toResponseDto(AutoRepairShop entity) {
    	AutoRepairShopDTO dto = mapper.map(entity, AutoRepairShopDTO.class);
        dto.setId(entity.getId());
        return dto;
    }
    
    public AutoRepairShop toEntity(AutoRepairShopDTO dto) throws ParseException {
    	AutoRepairShop entity = mapper.map(dto, AutoRepairShop.class);
        return entity;
    }
}
