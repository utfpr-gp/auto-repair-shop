package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.VehicleDTO;
import br.edu.utfpr.autorepairshop.service.ClientService;
import br.edu.utfpr.autorepairshop.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Cleaner;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ClientService clientService;

    @GetMapping
    private ResponseEntity<Iterable<Vehicle>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll());
    }



    @PostMapping
    public ModelAndView save(@RequestParam("photo")MultipartFile file, @RequestParam("client_id")Long id, @Validated VehicleDTO vehicleDTO, Errors errors){

        Optional<Client> client = clientService.findById(id);

        if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("vehicle-form");
            mv.addObject("dto", vehicleDTO);
            mv.addObject("client", client.get());
            mv.addObject("errors", errors.getAllErrors());
            return mv;
        }

        ModelAndView mv = new ModelAndView("redirect:veiculos");



        vehicleDTO.setClient(client.get());

        byte[] photo = vehicleService.convertPhoto(file);
        vehicleDTO.setImage(photo);

        vehicleService.save(vehicleDTO);
        return mv;
    }
}
