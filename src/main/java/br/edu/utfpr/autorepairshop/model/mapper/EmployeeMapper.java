package br.edu.utfpr.autorepairshop.model.mapper;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

	@Autowired
	private ModelMapper mapper;

	public Employee toEntity(EmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return employee;
	}
}
