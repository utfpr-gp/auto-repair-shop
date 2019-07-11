package br.edu.utfpr.autorepairshop;

import java.util.ArrayList;

import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.utfpr.autorepairshop.model.BrandEnum;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.repository.CredentialRepository;
import br.edu.utfpr.autorepairshop.security.RoleEnum;
import br.edu.utfpr.autorepairshop.util.PasswordUtil;

@SpringBootApplication
public class AutoRepairShopApplication {

	@Autowired
	public CredentialService credentialService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {

		ArrayList<String> marcas = BrandEnum.getValues();

		for(String marca : marcas)
			System.out.println(marca + "333333333333333333333333333333333333333333333333");

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
		};
	}
}
