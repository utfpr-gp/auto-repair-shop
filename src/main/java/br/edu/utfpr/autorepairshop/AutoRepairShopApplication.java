package br.edu.utfpr.autorepairshop;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.utfpr.autorepairshop.model.BrandEnum;

@SpringBootApplication
public class AutoRepairShopApplication {

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
}
