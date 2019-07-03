package br.edu.utfpr.autorepairshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.autorepairshop.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
