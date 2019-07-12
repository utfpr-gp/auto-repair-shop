package br.edu.utfpr.autorepairshop.model.service;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Service
public class CredentialService {

    @Autowired
    CredentialRepository credentialRepository;

    public Credential findByEmail(String email){
        return credentialRepository.findByEmail(email);
    }
}
