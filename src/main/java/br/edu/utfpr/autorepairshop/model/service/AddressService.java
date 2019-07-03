package br.edu.utfpr.autorepairshop.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.repository.AddressRpository;

@Service
public class AddressService {
	@Autowired
	AddressRpository addressRpository;
	
	public Address save(Address auto) {
		return addressRpository.save(auto);		
	}
}