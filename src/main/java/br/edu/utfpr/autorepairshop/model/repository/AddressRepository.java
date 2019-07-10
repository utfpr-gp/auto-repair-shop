package br.edu.utfpr.autorepairshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.autorepairshop.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}