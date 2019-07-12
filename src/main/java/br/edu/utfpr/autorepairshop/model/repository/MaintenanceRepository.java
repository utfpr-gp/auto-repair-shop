package br.edu.utfpr.autorepairshop.model.repository;

import br.edu.utfpr.autorepairshop.model.Maintenance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaintenanceRepository  extends JpaRepository<Maintenance, Long> {
	@Query("SELECT m from Maintenance m where m.vehicle.id = :id")
	List<Maintenance> findByVehicle(@Param("id") Long id);

	List<Maintenance> findByClientId(Long credentialId);
}
