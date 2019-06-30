package br.edu.utfpr.autorepairshop.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.dto.AddressDTO;

@Component
public class AddressMapper {
	
	@Autowired
    private ModelMapper mapper;
	
	 public AddressDTO toDto(Address entity) {
		 AddressDTO dto = mapper.map(entity, AddressDTO.class);
	        return dto;
	 }	 
}
