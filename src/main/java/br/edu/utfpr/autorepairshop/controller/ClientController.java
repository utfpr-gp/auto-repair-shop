package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public ModelAndView save( HttpServletRequest request){
        ModelAndView mv = new ModelAndView("vehicle-form");

        Client client = formatClientToSave(request);

        clientService.save(client);

        mv.addObject("client",client);
        return mv;
    }



    private Client formatClientToSave(HttpServletRequest request){
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setTelephone(request.getParameter("telefone"));
        client.setAddress(new Address(
                request.getParameter("street"),
                request.getParameter("city"),
                request.getParameter("state"),
                request.getParameter("cep"),
                request.getParameter("number")
        ));
        client.setCredential(new Credential(
                request.getParameter("email"),
                request.getParameter("password"),
                "client"
        ));

        String data = request.getParameter("birthDate");
        System.out.println("Kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk "+data);
        try {
            client.setDateBirth(new SimpleDateFormat("yyyy-MM-dd").parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return client;
    }
}
