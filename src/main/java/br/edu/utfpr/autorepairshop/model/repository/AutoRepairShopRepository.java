package br.edu.utfpr.autorepairshop.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.utfpr.autorepairshop.model.AutoRepairShop;

public interface AutoRepairShopRepository extends JpaRepository<AutoRepairShop, Long> {
	
	@Query("SELECT a FROM AutoRepairShop a WHERE cnpj = :cnpj")
	List<AutoRepairShop> findByCnpj(@Param("cnpj") String cnpj);

}