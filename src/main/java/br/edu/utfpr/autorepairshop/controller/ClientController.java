package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDTO;
import br.edu.utfpr.autorepairshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    private ResponseEntity<Iterable<Client>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("/cadastro")
    public ModelAndView showNewClientForm(){

        ModelAndView mv = new ModelAndView("client-form");

        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView save(@Validated ClientDTO clientDTO, Errors errors){

        if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("client-form");
            mv.addObject("dto", clientDTO);
            mv.addObject("errors", errors.getAllErrors());
            return mv;
        }

        ModelAndView mv = new ModelAndView("vehicle-form");

        Client client = clientService.save(clientDTO);

        mv.addObject("client",client);
        return mv;
    }

}
