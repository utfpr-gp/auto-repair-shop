package br.edu.utfpr.autorepairshop.controller;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import br.edu.utfpr.autorepairshop.model.dto.AddressDTO;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
import br.edu.utfpr.autorepairshop.security.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
import br.edu.utfpr.autorepairshop.model.service.AddressService;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import br.edu.utfpr.autorepairshop.model.service.EmployeeService;

@Controller
@PreAuthorize("hasAnyRole('ADMIN') or hasAnyRole('MANAGER')")
@RequestMapping("/funcionarios")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	AddressService addressService;

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
	public ModelAndView save(@Validated EmployeeDTO dto, @Validated AddressDTO addressDto, @Validated CredentialDTO credentialDto, Errors errors, RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("employee/form");
			mv.addObject("dto", dto);
			mv.addObject("addressDto", addressDto);
			mv.addObject("credentialDto", credentialDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		Address address = addressMapper.toEntity(addressDto);
		Optional<Credential> c = credentialService.findByEmail(credentialDto.getEmail());

		if (c.isPresent()) {
			ModelAndView mv = new ModelAndView("employee/form");
			mv.addObject("dto", dto);
			mv.addObject("addressDto", addressDto);
			mv.addObject("credentialDto", credentialDto);
			mv.addObject("messageError", "Email já utilizado");
			return mv;
		}
		addressService.save(address);

		Credential credential = credentialMapper.toEntity(credentialDto);
		credential.setRole(RoleEnum.ROLE_EMPLOYEE);

		credentialService.save(credential);
		Employee employee = employeeMapper.toEntity(dto);
		employee.setAddress(address);
		employee.setCredential(credential);
		employeeService.save(employee);
		redirectAttributes.addFlashAttribute("message", "Funcionário salvo com sucesso!");
		return new ModelAndView("redirect:funcionarios");
	}

	@PostMapping("/update")
	public ModelAndView update(@Validated EmployeeDTO dto, @Validated AddressDTO addressDto,  @Validated CredentialDTO credentialDto, Errors errors, RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("employee/edit");
			mv.addObject("dto", dto);
			mv.addObject("addressDto", addressDto);
			mv.addObject("credentialDto", credentialDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		Address address = addressMapper.toEntity(addressDto);
		Optional<Credential> c = credentialService.findByEmail(credentialDto.getEmail());

		if (c.isPresent()) {
			ModelAndView mv = new ModelAndView("employee/form");
			mv.addObject("dto", dto);
			mv.addObject("CredentialDto", credentialDto);
			mv.addObject("messageError", "Email já utilizado");
			return mv;
		}
		addressService.save(address);

		Credential credential = credentialMapper.toEntity(credentialDto);
		credential.setRole(RoleEnum.ROLE_EMPLOYEE);

		credentialService.save(credential);
		Employee employee = employeeMapper.toEntity(dto);
		employee.setAddress(address);
		employee.setCredential(credential);
		employeeService.save(employee);
		redirectAttributes.addFlashAttribute("message", "Funcionário atualizado com sucesso!");
		return new ModelAndView("redirect:/funcionarios");
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		employeeService.delete(id);
		redirectAttributes.addFlashAttribute("msg", "Funcionario removido com sucesso!");
		return "redirect:/funcionarios";
	}
}