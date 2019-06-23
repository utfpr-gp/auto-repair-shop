package br.edu.utfpr.autorepairshop.service;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

}
