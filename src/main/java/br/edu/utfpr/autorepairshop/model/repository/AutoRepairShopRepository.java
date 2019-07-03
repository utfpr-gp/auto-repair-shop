package br.edu.utfpr.autorepairshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.autorepairshop.model.AutoRepairShop;

public interface AutoRepairShopRepository extends JpaRepository<AutoRepairShop, Long> {

}