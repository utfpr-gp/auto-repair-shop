package br.edu.utfpr.autorepairshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.autorepairshop.model.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Long>{

}
