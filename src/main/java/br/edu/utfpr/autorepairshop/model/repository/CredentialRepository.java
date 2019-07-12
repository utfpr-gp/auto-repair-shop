package br.edu.utfpr.autorepairshop.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.utfpr.autorepairshop.model.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Long>{

    @Query("SELECT c FROM Credential c WHERE email = :email ")
    Optional<Credential> findByEmail(@Param("email") String email);

}
