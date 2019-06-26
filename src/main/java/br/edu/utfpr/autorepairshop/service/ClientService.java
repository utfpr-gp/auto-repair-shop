package br.edu.utfpr.autorepairshop.service;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.dto.ClientDTO;
import br.edu.utfpr.autorepairshop.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client save(Client client){
//        Client client = new Client();
//        client.setName(clientDTO.getName());
//        client.setTelephone(clientDTO.getTelephone());
//        client.setAddress(new Address(
//            clientDTO.getStreet(),
//                clientDTO.getCity(),
//                clientDTO.getState(),
//                clientDTO.getCep(),
//                clientDTO.getNumber()
//
//        ));
//        client.setCredential(new Credential(
//            clientDTO.getEmail(),
//                clientDTO.getPassword(),
//                "client"
//        ));
//        client.setDateBirth(clientDTO.getBirthDate());

        return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

}
