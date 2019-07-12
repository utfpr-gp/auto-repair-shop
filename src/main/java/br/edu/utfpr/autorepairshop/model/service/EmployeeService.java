package br.edu.utfpr.autorepairshop.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public Employee save(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> findAll(){
		return repository.findAll();
	}

	public Optional<Employee> findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Long id){
		this.repository.deleteById(id);
	}
}
