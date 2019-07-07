package br.edu.utfpr.autorepairshop.controller;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.dto.EmployeeDTO;
import br.edu.utfpr.autorepairshop.model.mapper.AddressMapper;
import br.edu.utfpr.autorepairshop.model.mapper.CredentialMapper;
import br.edu.utfpr.autorepairshop.model.mapper.EmployeeMapper;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import br.edu.utfpr.autorepairshop.model.service.EmployeeService;

@Controller
@RequestMapping("/funcionarios")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	AddressMapper addressMapper;

	@Autowired
	CredentialMapper credentialMapper;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	CredentialService credentialService;

	@GetMapping("/novo")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("employee/form");
		return mv;
	}

	@GetMapping
	public ModelAndView index() {

		List<Employee> auto = employeeService.findAll();

		List<EmployeeDTO> empDTOs = auto.stream().map(s -> employeeMapper.toResponseDto(s))
				.collect(Collectors.toList());

		ModelAndView mv = new ModelAndView("employee/index");
		mv.addObject("employees", empDTOs);

		return mv;
	}

	@PostMapping
	public ModelAndView save(@Validated EmployeeDTO employeeDto, Errors errors, RedirectAttributes redirectAttributes) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("employee/form");
			mv.addObject("dto", employeeDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		redirectAttributes.addFlashAttribute("message", "Funcionário salvo com sucesso!");

		Address address = addressMapper.toEntity(employeeDto);
		Credential credential = credentialMapper.toEntity(employeeDto);
		credential.setRole("funcionario");

		employeeDto.setAddress(address);
		employeeDto.setCredential(credential);

		Employee employee = employeeMapper.toEntity(employeeDto);
		employeeService.save(employee);
		return new ModelAndView("redirect:funcionarios");
	}

	@GetMapping("/{id}")
	public ModelAndView showFormForUpdate(@PathVariable("id") Long id) {

		ModelAndView mv = new ModelAndView("employee/edit");

		Optional<Employee> employee = employeeService.findById(id);

		if (!employee.isPresent()) {
			throw new EntityNotFoundException("O funcionário não foi encontrada pelo id informado.");
		}
		EmployeeDTO employeeDTO = employeeMapper.toResponseDto(employee.get());
		mv.addObject("dto", employeeDTO);
		return mv;
	}

	@PutMapping
	public ModelAndView update(@Validated EmployeeDTO employeeDto, Errors errors,
			RedirectAttributes redirectAttributes) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("funcionarios/edit");
			mv.addObject("dto", employeeDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}
	
		Optional<Employee> employee = employeeService.findById(employeeDto.getId());
		if (!employee.isPresent()) {
			throw new EntityNotFoundException("O funcionario não foi encontrada pelo id informado.");
		}
		
		Address address = addressMapper.toEntity(employeeDto);
		Credential credential = credentialMapper.toEntity(employeeDto);

		Employee emp = employeeMapper.toEntity(employeeDto);
		emp.setAddress(address);
		emp.setCredential(credential);
		
		employeeService.save(emp);

		redirectAttributes.addFlashAttribute("message", "Funcionário atualizada com sucesso!");
		return new ModelAndView("redirect:funcionarios/");
	}
}