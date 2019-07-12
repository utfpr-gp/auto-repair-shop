package br.edu.utfpr.autorepairshop.model.mapper;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
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

	@Autowired
	private CredentialMapper credentialMapper;

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
		dto.setAddressDto(address.toDto(entity.getAddress()));
		dto.setCredentialDto(credentialMapper.toDto(entity.getCredential()));
		return dto;
	}
}
