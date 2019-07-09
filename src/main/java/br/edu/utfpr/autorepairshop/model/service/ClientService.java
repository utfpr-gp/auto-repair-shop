package br.edu.utfpr.autorepairshop.model.service;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDataDTO;
import br.edu.utfpr.autorepairshop.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }

    public Client save(Client entity){
        return this.clientRepository.save(entity);
    }

    public void update(Client  clientData, Long id){
        Optional<Client> client = findById(id);

        client.get().setAddress(clientData.getAddress());
        client.get().setTelephone(clientData.getTelephone());
        client.get().setName(clientData.getName());
        client.get().setBirthDate(clientData.getBirthDate());
        client.get().getCredential().setEmail(clientData.getCredential().getEmail());

        clientRepository.save(client.get());
    }

    public Optional<Client> findById(Long id){return this.clientRepository.findById(id); }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
