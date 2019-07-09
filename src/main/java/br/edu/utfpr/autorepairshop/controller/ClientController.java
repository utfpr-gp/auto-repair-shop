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
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public ModelAndView index() {
        List<Client> clients = clientService.findAll();

        List<ClientDataDTO> clientDataDTOS = clients.stream()
                .map(s -> clientMapper.toResponseDto(s))
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("client/index");
        mv.addObject("clients", clientDataDTOS);

        return mv;
    }


    @GetMapping("/novo")
    public ModelAndView showNewClientForm(){

        ModelAndView mv = new ModelAndView("client/form");

        return mv;
    }

    @GetMapping("/{id}")
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
    public ModelAndView save(@Validated ClientDataDTO clientDataDTO,
                             Errors errors,
                             RedirectAttributes redirectAttributes){

        System.out.println("ADWDKNAWKDNAWDKLNAWKLD"+ clientDataDTO.getBirthDate());


        if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("client/form");
            mv.addObject("dto", clientDataDTO);
            mv.addObject("errors", errors.getAllErrors());
            return mv;
        }

        if (!clientDataDTO.getPassword().equals(clientDataDTO.getPasswordConfirmation())){
            ModelAndView mv = new ModelAndView("client/form");
            mv.addObject("dto", clientDataDTO);
            mv.addObject("passwordError", "Senhas não batem.");
            return mv;
        }

        redirectAttributes.addFlashAttribute("message", "Cliente salvo com sucesso!");

        Address address = addressMapper.toEntity(clientDataDTO);
        Credential credential = credentialMapper.toEntity(clientDataDTO);

        clientDataDTO.setAddress(address);
        clientDataDTO.setCredential(credential);

        Client client =  clientMapper.toEntity(clientDataDTO);

        System.out.println("CHEGOUUUU AQUI!!" + client.getBirthDate());
        clientService.save(client);

        return new ModelAndView("redirect:novo");
    }

    @PutMapping("/{id}")
    public ModelAndView save(@PathVariable("id") Long id,
                             @Validated ClientDataDTO clientDataDTO,
                             Errors errors,
                             RedirectAttributes redirectAttributes) {

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

       clientService.update(client, id);

        return new ModelAndView("redirect:/clientes");
    }


    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable Long id){

        Optional<Client> client = clientService.findById(id);

        if (!client.isPresent()){
            return new ModelAndView("redirect:/clientes");
        }

        clientService.deleteById(id);
        return new ModelAndView("redirect:/clientes");
    }

}
