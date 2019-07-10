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

	@PostMapping
	public ModelAndView save(@Validated EmployeeDTO dto, Errors errors, RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("employee/form");
			mv.addObject("dto", dto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		Address address = addressMapper.toEntity(dto);
		Credential credential = credentialMapper.toEntity(dto);
		credential.setRole("funcionario");

		Optional<Credential> c = credentialService.findByEmail(credential.getEmail());

		if (c.isPresent()) {
			ModelAndView mv = new ModelAndView("employee/form");
			dto.setEmail("");
			mv.addObject("dto", dto);
			mv.addObject("messageError", "Email já utilizado");
			return mv;
		}

		dto.setAddress(address);
		dto.setCredential(credential);

		Employee employee = employeeMapper.toEntity(dto);
		employeeService.save(employee);
		redirectAttributes.addFlashAttribute("message", "Funcionário salvo com sucesso!");
		return new ModelAndView("redirect:funcionarios");
	}

	@PutMapping
	public ModelAndView update(@Validated EmployeeDTO dto, Errors errors, RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("employee/edit");
			mv.addObject("dto", dto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		Address address = addressMapper.toEntity(dto);
		Credential credential = credentialMapper.toEntity(dto);
		credential.setRole("funcionario");

		Optional<Employee> employee = employeeService.findById(dto.getId());
		Optional<Credential> c = credentialService.findByEmail(employee.get().getCredential().getEmail());

		if (c.isPresent()) {
			if (!c.get().getEmail().equals(credential.getEmail())) {
				ModelAndView mv = new ModelAndView("employee/edit");
				dto.setEmail("");
				mv.addObject("dto", dto);
				mv.addObject("messageError", "Email já utilizado");
				return mv;
			}
		}

		dto.setAddress(address);
		dto.setCredential(credential);

		Employee emp = employeeMapper.toEntity(dto);
		employeeService.save(emp);
		redirectAttributes.addFlashAttribute("message", "Funcionário atualizado com sucesso!");
		return new ModelAndView("redirect:funcionarios");
	}
}