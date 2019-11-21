package br.edu.utfpr.autorepairshop.model.service;

import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.repository.VehicleRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll(){
        return this.vehicleRepository.findAll();
    }

    public Vehicle save(Vehicle entity){
        return this.vehicleRepository.save(entity);
    }

    public Optional<Vehicle> findById(Long id){
        return this.vehicleRepository.findById(id);
    }

    public List<Vehicle> findByClientId(Long id) {
        return this.vehicleRepository.findByClientId(id);
    }

    public void delete(Long id){
        this.vehicleRepository.deleteById(id);
    }

	public Optional<Vehicle> findByPlaca(String placa) {
		return this.vehicleRepository.findByPlaca(placa);
	}

}
