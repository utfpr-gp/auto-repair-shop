package br.edu.utfpr.autorepairshop.model.repository;

import br.edu.utfpr.autorepairshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCredentialId(Long credentialId);
}
