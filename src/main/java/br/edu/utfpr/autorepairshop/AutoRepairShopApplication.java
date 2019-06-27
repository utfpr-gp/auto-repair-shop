package br.edu.utfpr.autorepairshop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoRepairShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoRepairShopApplication.class, args);
	}


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
