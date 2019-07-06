package br.edu.utfpr.autorepairshop.model.mapper;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.AutoRepairShop;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.dto.AutoRepairShopDTO;
import br.edu.utfpr.autorepairshop.model.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AddressMapper address;

	public EmployeeDTO toDto(Employee entity) {
    	EmployeeDTO dto = mapper.map(entity, EmployeeDTO.class);
        return dto;
    }
	
	public Employee toEntity(EmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return employee;
	}

	public EmployeeDTO toResponseDto(Employee entity) {
		EmployeeDTO dto = mapper.map(entity, EmployeeDTO.class);
		dto.setAddressDTO(address.toDto(entity.getAddress()));
		return dto;
	}
}
