package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.Maintenance;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.ClientToFormDTO;
import br.edu.utfpr.autorepairshop.model.dto.EmployeeDTO;
import br.edu.utfpr.autorepairshop.model.dto.MaintenanceDTO;
import br.edu.utfpr.autorepairshop.model.dto.VehicleDTO;
import br.edu.utfpr.autorepairshop.model.mapper.EmployeeMapper;
import br.edu.utfpr.autorepairshop.model.mapper.MaintenanceMapper;
import br.edu.utfpr.autorepairshop.model.mapper.VehicleMapper;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import br.edu.utfpr.autorepairshop.model.service.EmployeeService;
import br.edu.utfpr.autorepairshop.model.service.MaintenanceService;
import br.edu.utfpr.autorepairshop.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/atendimentos")
@PreAuthorize("hasAnyRole('ADMIN') or hasAnyRole('MANAGER') or hasAnyRole('EMPLOYEE')")
@Controller
public class MaintenanceController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private CredentialService credentialService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private MaintenanceService maintenanceService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Autowired
	private MaintenanceMapper maintenanceMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@GetMapping
	public ModelAndView index() {
		List<Maintenance> maintenances = maintenanceService.findAll();

		List<MaintenanceDTO> maintenanceDTOs = maintenances.stream()
				.map(s -> maintenanceMapper.toResponseDto(s))
				.collect(Collectors.toList());

		ModelAndView mv = new ModelAndView("maintenance/index");
		mv.addObject("maintenances", maintenanceDTOs);

		return mv;
	}

	@GetMapping("/novo")
	public ModelAndView showForm() {
		List<Vehicle> vehicles = vehicleService.findAll();
		List<VehicleDTO> vehiclesDto = vehicles.stream()
				.map(vehicle -> vehicleMapper.toResponseDto(vehicle))
				.collect(Collectors.toList());

		List<Employee> employees = employeeService.findAll();
		List<EmployeeDTO> employeesDto = employees.stream()
				.map(employee -> employeeMapper.toResponseDto(employee))
				.collect(Collectors.toList());

		ModelAndView mv = new ModelAndView("maintenance/form");
		mv.addObject("vehiclesDto", vehiclesDto);
		mv.addObject("employeesDto", employeesDto);

		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView showEdit(@PathVariable("id") Long id) {
		List<Vehicle> vehicles = vehicleService.findAll();
		List<VehicleDTO> vehiclesDto = vehicles.stream()
				.map(vehicle -> vehicleMapper.toResponseDto(vehicle))
				.collect(Collectors.toList());

		List<Employee> employees = employeeService.findAll();
		List<EmployeeDTO> employeesDto = employees.stream()
				.map(employee -> employeeMapper.toResponseDto(employee))
				.collect(Collectors.toList());

		ModelAndView mv = new ModelAndView("maintenance/form");

		Optional<Maintenance> maintenance = maintenanceService.findById(id);

		if (!maintenance.isPresent()) {
			throw new EntityNotFoundException("O atendimento não foi encontrada pelo id informado.");
		}
		MaintenanceDTO maintenanceDto = maintenanceMapper.toResponseDto(maintenance.get());
		mv.addObject("dto", maintenanceDto);
		mv.addObject("vehiclesDto", vehiclesDto);
		mv.addObject("employeesDto", employeesDto);
		return mv;
	}

	@GetMapping("/cliente")
	@PreAuthorize("hasAnyRole('CLIENT')")
	public ModelAndView myVehicles() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Optional<Credential> o = credentialService.findByEmail(securityContext.getAuthentication().getName());
		Optional<Client> clientOptional = this.clientService.findByCredentialId(o.get().getId());
		ModelAndView mv = new ModelAndView("maintenance/index");

		if (clientOptional.isPresent()) {
			List<Maintenance> maintenances = maintenanceService.findByClientId(clientOptional.get().getId());

			List<MaintenanceDTO> maintenanceDtos = maintenances.stream()
					.map(s -> maintenanceMapper.toResponseDto(s))
					.collect(Collectors.toList());
			mv.addObject("maintenances", maintenanceDtos);
		}

		return mv;
	}

	@GetMapping(value = "pesquisa")
	public ModelAndView search(@RequestParam(value = "search", defaultValue = "") String placa) {
		return new ModelAndView();
	}

	@PostMapping
	public ModelAndView save(@Validated MaintenanceDTO dto, Errors errors, RedirectAttributes redirectAttributes) {

		List<Vehicle> vehicles = vehicleService.findAll();
		List<VehicleDTO> vehiclesDto = vehicles.stream()
				.map(vehicle -> vehicleMapper.toResponseDto(vehicle))
				.collect(Collectors.toList());

		List<Employee> employees = employeeService.findAll();
		List<EmployeeDTO> employeesDto = employees.stream()
				.map(employee -> employeeMapper.toResponseDto(employee))
				.collect(Collectors.toList());

		if(errors.hasErrors()){
			ModelAndView mv = new ModelAndView("maintenance/form");
			mv.addObject("dto", dto);
			mv.addObject("vehiclesDto", vehiclesDto);
			mv.addObject("employeesDto", employeesDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		redirectAttributes.addFlashAttribute("message", "Manutenção salva com sucesso!");
		Maintenance maintenance = maintenanceMapper.toEntity(dto);
		maintenance.setId(dto.getRegistration());
		maintenanceService.save(maintenance);

		return new ModelAndView("redirect:atendimentos");
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		maintenanceService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Atendimento removido com sucesso!");
		return "redirect:/atendimentos";
	}
}
