package br.edu.utfpr.autorepairshop.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.Credential;
import java.util.List;

import br.edu.utfpr.autorepairshop.util.PasswordUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.autorepairshop.model.repository.CredentialRepository;

@Service
public class CredentialService {
    @Autowired
    CredentialRepository repository;

    @Transactional
    public Credential save(Credential credential) {
        credential.setPassword(PasswordUtil.generateBCrypt(credential.getPassword()));
        if(credential.getPasswordConfirmation() != null)
        	credential.setPasswordConfirmation(PasswordUtil.generateBCrypt(credential.getPasswordConfirmation()));
        return repository.save(credential);
    }
    
    @Transactional
    public Credential saveWithoutEncryption(Credential credential) {
        return repository.save(credential);
    }

    @Transactional
    public void delete(Credential credential) {
        repository.delete(credential);
    }

    public Optional<Credential> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<Credential> findById(Long id) {
        return repository.findById(id);
    }

    public List<Credential> findAll() {
        return repository.findAll();
    }

    public Page<Credential> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
