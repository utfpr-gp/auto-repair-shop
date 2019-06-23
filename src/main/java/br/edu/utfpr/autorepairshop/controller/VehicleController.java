package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.service.ClientService;
import br.edu.utfpr.autorepairshop.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ModelAndView save(HttpServletRequest request, @RequestParam("image")MultipartFile file, @RequestParam("client_id")Long id){

        ModelAndView mv = new ModelAndView("redirect:veiculos");



        byte[] foto = vehicleService.convertPhoto(file);
        Optional<Client> client = clientService.findById(id);
        System.out.println(client);
        System.out.println(request.getParameter("image"));

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(request.getParameter("brand"));
        vehicle.setColor(request.getParameter("color"));
        vehicle.setType(request.getParameter("type"));
        vehicle.setModel(request.getParameter("model"));
        vehicle.setPlaca(request.getParameter("placa"));
        vehicle.setImage(foto);
        vehicle.setClient(client.get());

        vehicleService.save(vehicle);

        System.out.println(vehicle);

        return mv;
    }
}
