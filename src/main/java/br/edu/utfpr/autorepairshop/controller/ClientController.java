package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.mapper.AddressMapper;
import br.edu.utfpr.autorepairshop.model.mapper.ClientMapper;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDataDTO;
import br.edu.utfpr.autorepairshop.model.mapper.CredentialMapper;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CredentialMapper credentialMapper;

    @GetMapping
    private ResponseEntity<Iterable<Client>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("/novo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ModelAndView showNewClientForm(){

        ModelAndView mv = new ModelAndView("client/form");

        return mv;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ModelAndView showFormForUpdate(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("client/form");

        Optional<Client> client = clientService.findById(id);

        if (!client.isPresent()){
            throw new EntityNotFoundException("O veículo não foi encontrado pelo id informado.");
        }

        ClientDataDTO clientDataDTO = clientMapper.toResponseDto(client.get());
        mv.addObject("dto", clientDataDTO);
        return mv;
    }

    @PostMapping("/novo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ModelAndView save(@Validated ClientDataDTO clientDataDTO,
                             Errors errors,
                             RedirectAttributes redirectAttributes){


        if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("client/form");
            mv.addObject("dto", clientDataDTO);
            mv.addObject("errors", errors.getAllErrors());
            return mv;
        }

        redirectAttributes.addFlashAttribute("message", "Cliente salvo com sucesso!");

        Address address = addressMapper.toEntity(clientDataDTO);
        Credential credential = credentialMapper.toEntity(clientDataDTO);

        clientDataDTO.setAddress(address);
        clientDataDTO.setCredential(credential);

        Client client =  clientMapper.toEntity(clientDataDTO);

        clientService.save(client);

        return new ModelAndView("redirect:novo");
    }
}
