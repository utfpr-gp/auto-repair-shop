package br.edu.utfpr.autorepairshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.dto.AddressDTO;
import br.edu.utfpr.autorepairshop.model.dto.EmployeeDTO;
import br.edu.utfpr.autorepairshop.model.mapper.AddressMapper;
import br.edu.utfpr.autorepairshop.model.mapper.ClientMapper;
import br.edu.utfpr.autorepairshop.model.mapper.CredentialMapper;
import br.edu.utfpr.autorepairshop.model.mapper.EmployeeMapper;
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
    
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("employee/form");
		return mv;
	}

	@PostMapping
	public ModelAndView save(@Validated EmployeeDTO employeeDto, 
			Errors errors, RedirectAttributes redirectAttributes) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("employee/form");
			mv.addObject("dto", employeeDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		redirectAttributes.addFlashAttribute("message", "Funcionário salvo com sucesso!");

		Address address = addressMapper.toEntity(employeeDto);
		Credential credential = credentialMapper.toEntity(employeeDto);

		Employee employee = employeeMapper.toEntity(employeeDto);

		employeeService.save(employee);

		return new ModelAndView("redirect:funcionarios");
	}
}