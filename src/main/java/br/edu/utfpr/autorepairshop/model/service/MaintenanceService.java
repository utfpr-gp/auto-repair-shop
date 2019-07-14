package br.edu.utfpr.autorepairshop.model.service;

import br.edu.utfpr.autorepairshop.model.Maintenance;
import br.edu.utfpr.autorepairshop.model.repository.MaintenanceRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Maintenance> findAll(){
        return this.maintenanceRepository.findAll();
    }

    public List<Maintenance> findByVehicle(Long id){
        return this.maintenanceRepository.findByVehicle(id);
    }
    
    public Maintenance save(Maintenance entity){
        return this.maintenanceRepository.save(entity);
    }

    public Optional<Maintenance> findById(Long id){
        return this.maintenanceRepository.findById(id);
    }

    public List<Maintenance> findByClientId(Long id) {
        return this.maintenanceRepository.findByClientId(id);
    }
    
    public void deleteById(Long id) {
    	this.maintenanceRepository.deleteById(id);
    }
}
