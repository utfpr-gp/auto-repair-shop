package br.edu.utfpr.autorepairshop.model.repository;

import br.edu.utfpr.autorepairshop.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Long> {

    Credential findByEmail(String email);
}
