package br.edu.utfpr.autorepairshop;


import java.sql.Date;
import java.util.ArrayList;

import br.edu.utfpr.autorepairshop.model.service.AddressService;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import br.edu.utfpr.autorepairshop.model.service.EmployeeService;
import br.edu.utfpr.autorepairshop.model.service.VehicleService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.BrandEnum;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.AddressDTO;
import br.edu.utfpr.autorepairshop.model.mapper.AddressMapper;
import br.edu.utfpr.autorepairshop.model.mapper.ClientMapper;
import br.edu.utfpr.autorepairshop.model.mapper.CredentialMapper;
import br.edu.utfpr.autorepairshop.model.repository.CredentialRepository;
import br.edu.utfpr.autorepairshop.security.RoleEnum;
import br.edu.utfpr.autorepairshop.util.PasswordUtil;

@SpringBootApplication
public class AutoRepairShopApplication {

	@Autowired
	public CredentialService credentialService;

	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public VehicleService vehicleService;
	
	@Autowired
	public ClientService clientService;

	@Autowired
	public AddressService addressService;
	
	@Autowired 
	public AddressMapper addressMapper;
	
	@Autowired
	public CredentialMapper credentialMapper;
	
	@Autowired
	public ClientMapper clientMapper;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
//
//	@Bean
//	public FilterRegistrationBean authenticationFilterBean() {
//		final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
//		filterRegBean.setFilter(new AuthenticationFilter());
//		filterRegBean.addUrlPatterns("/*");
//		filterRegBean.setEnabled(Boolean.TRUE);
//		filterRegBean.setName("Autenticação");
//		filterRegBean.setAsyncSupported(Boolean.TRUE);
//		return filterRegBean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AutoRepairShopApplication.class, args);
	}
  
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Credential credential = new Credential();
			credential.setEmail("admin@utfpr.edu.br");
			credential.setRole(RoleEnum.ROLE_ADMIN);
			credential.setPassword("admin");
			credentialService.save(credential);
			
			Credential credentialEmployee = new Credential();
			credentialEmployee.setEmail("employee@utfpr.edu.br");
			credentialEmployee.setRole(RoleEnum.ROLE_EMPLOYEE);
			credentialEmployee.setPassword("employee");
			credentialService.save(credentialEmployee);
			
			Credential credentialClient = new Credential();
			credentialClient.setEmail("client@utfpr.edu.br");
			credentialClient.setRole(RoleEnum.ROLE_CLIENT);
			credentialClient.setPassword("client");
			credentialService.save(credentialClient);
			
			Address address = new Address();
			address.setCep("85390000");
			address.setState("Paraná");
			address.setCity("Guarapuava");
			address.setStreet("Rua X");
			address.setNumber("123");
			addressService.save(address);
//			AddressDTO addressDto = addressMapper.toDto(address);
//			
//			Employee employee = new Employee(); 
//			employee.setName("João Ferreira");
//			employee.setTelephone("(42) 9999-9999");
//			employee.setCellular("(42) 9999-9999");
//			employee.setAddress(address);
//			employee.setCredential(credentialEmployee);
//			employeeService.save(employee);
			
//			Client client = new Client();
//			client.setAddress(address);
//			client.setBirthDate(new Date("22/09/1997"));
//			client.setName("Andressa");
//			client.setTelephone("(42) 99999-9999");
//			clientService.save(client);
//			
//			Vehicle vehicle = new Vehicle();
//			vehicle.setClient(client);
//			vehicle.setPlaca("AQT-1902");
//			vehicle.setColor("Preto");
//			vehicle.setType("Carro");
//			vehicle.setModel("Corolla");
//			vehicle.setBrand("Toyota");
//			vehicleService.save(vehicle);
		};
	}
}
