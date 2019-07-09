package br.edu.utfpr.autorepairshop;

import br.edu.utfpr.autorepairshop.filter.AuthenticationFilter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.repository.CredentialRepository;
import br.edu.utfpr.autorepairshop.security.RoleEnum;
import br.edu.utfpr.autorepairshop.util.PasswordUtil;

@SpringBootApplication
public class AutoRepairShopApplication {

	@Autowired
	public CredentialRepository credentialRepository;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public FilterRegistrationBean authenticationFilterBean() {
		final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new AuthenticationFilter());
		filterRegBean.addUrlPatterns("/*");
		filterRegBean.setEnabled(Boolean.TRUE);
		filterRegBean.setName("Autenticação");
		filterRegBean.setAsyncSupported(Boolean.TRUE);
		return filterRegBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(AutoRepairShopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Credential credential = new Credential();
			credential.setEmail("admin@utfpr.edu.br"); 
			credential.setRole(RoleEnum.ROLE_ADMIN);
			credential.setPassword(PasswordUtil.generateBCrypt("admin"));
			credentialRepository.save(credential);
		};
	}
}
