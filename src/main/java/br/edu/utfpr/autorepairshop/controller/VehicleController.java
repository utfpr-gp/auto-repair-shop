package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.BrandEnum;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.ClientToFormDTO;
import br.edu.utfpr.autorepairshop.model.dto.ImageDTO;
import br.edu.utfpr.autorepairshop.model.dto.VehicleDTO;
import br.edu.utfpr.autorepairshop.model.mapper.VehicleMapper;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import br.edu.utfpr.autorepairshop.model.service.ImageService;
import br.edu.utfpr.autorepairshop.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/veiculos")
@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    ImageService imageService;

    @GetMapping
    public ModelAndView index() {
        List<Vehicle> vehicles = vehicleService.findAll();

        List<VehicleDTO> vehicleDTOs = vehicles.stream()
                .map(s -> vehicleMapper.toResponseDto(s))
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("vehicle/index");
        mv.addObject("vehicles", vehicleDTOs);

        return mv;
    }

    @GetMapping("/meus")
    public ModelAndView myVehicles() {
//        JwtUser currentUser = (JwtUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //todo após login pronto descomentar código acima alterar o 1 abaxo por currentUser.getId();
        Optional<Client> clientOptional = this.clientService.findByCredentialId(1);
        ModelAndView mv = new ModelAndView("vehicle/my-vehicles");

        if (clientOptional.isPresent()) {
            List<Vehicle> vehicles = vehicleService.findByClientId(clientOptional.get().getId());

            List<VehicleDTO> vehicleDTOs = vehicles.stream()
                    .map(s -> vehicleMapper.toResponseDto(s))
                    .collect(Collectors.toList());
            mv.addObject("vehicles", vehicleDTOs);
        }

        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView showForm() {
        List<Client> clients = clientService.findAll();
        List<ClientToFormDTO> clientsDto = clients.stream()
                .map(client -> {
                    ClientToFormDTO clientDto = new ClientToFormDTO();
                    clientDto.setId(client.getId());
                    clientDto.setName(client.getName());
                    return clientDto;
                })
                .collect(Collectors.toList());
        ModelAndView mv = new ModelAndView("vehicle/form");
        mv.addObject("clientsDto", clientsDto);
        mv.addObject("brand", BrandEnum.getValues());
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView showFormForUpdate(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView("vehicle/form");

        Optional<Vehicle> optionalVehicle = vehicleService.findById(id);

        if(!optionalVehicle.isPresent()){
            throw new EntityNotFoundException("O veículo não foi encontrado pelo id informado.");
        }

        List<Client> clients = clientService.findAll();
        List<ClientToFormDTO> clientsDto = clients.stream()
                .map(client -> {
                    ClientToFormDTO clientDto = new ClientToFormDTO();
                    clientDto.setId(client.getId());
                    clientDto.setName(client.getName());
                    return clientDto;
                })
                .collect(Collectors.toList());

        VehicleDTO vehicleDTO = vehicleMapper.toResponseDto(optionalVehicle.get());
        mv.addObject("dto", vehicleDTO);
        mv.addObject("clientsDto", clientsDto);
        return mv;
    }

    @PostMapping
    public ModelAndView save(@Validated VehicleDTO  dto, Errors errors, RedirectAttributes redirectAttributes) {
        if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("vehicle/form");
            mv.addObject("dto", dto);
            mv.addObject("errors", errors.getAllErrors());
            return mv;
        }

        //Envia imagem e recupera URL
        if (!dto.getFile().isEmpty()) {
            ImageDTO image = this.imageService.upload(dto.getFile());
            dto.setImage(image.getUrl());
        }

        redirectAttributes.addFlashAttribute("message", "Veículo salvo com sucesso!");
        Vehicle vehicle = vehicleMapper.toEntity(dto);
        vehicle.setId(dto.getRegistration());
        vehicleService.save(vehicle);

        return new ModelAndView("redirect:veiculos");
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        this.vehicleService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Veiculo removido com sucesso!");
        return "redirect:/veiculos";
    }
}
