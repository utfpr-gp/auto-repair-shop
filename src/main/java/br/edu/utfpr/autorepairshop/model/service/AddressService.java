package br.edu.utfpr.autorepairshop.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
    AddressRepository addressRepository;
	
	public Address save(Address auto) {
		return addressRepository.save(auto);
	}
	
	public Optional<Address> findById(Long id) {
		return addressRepository.findById(id);
	}
}