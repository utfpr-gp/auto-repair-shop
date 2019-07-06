package br.edu.utfpr.autorepairshop.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.Employee;
import br.edu.utfpr.autorepairshop.model.repository.CredentialRepository;

@Service
public class CredentialService {
	@Autowired
	CredentialRepository repository;
	
	public Credential save(Credential credential) {
		return repository.save(credential);
	}
	
	public Optional<Credential> findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
