package br.edu.utfpr.autorepairshop.model.repository;

import br.edu.utfpr.autorepairshop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository  extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByClientId(Long credentialId);
}
