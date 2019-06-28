package br.edu.utfpr.autorepairshop.model.service;

import java.util.List;

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
}