package br.edu.utfpr.autorepairshop.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.AutoRepairShop;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.repository.AutoRepairShopRepository;

@Service
public class AutoRepairShopService {
	@Autowired
	AutoRepairShopRepository autoRepairShopRepository;
	
	public AutoRepairShop save(AutoRepairShop auto) {
		return autoRepairShopRepository.save(auto);		
	}

	public List<AutoRepairShop> findAll() {
		return autoRepairShopRepository.findAll();
	}

	public Optional<AutoRepairShop> findById(Long id) {
		return autoRepairShopRepository.findById(id);
	}

	public void deleteById(Long id) {
		 autoRepairShopRepository.deleteById(id);
	}
}