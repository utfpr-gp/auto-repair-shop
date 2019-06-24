package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.ClientToFormDTO;
import br.edu.utfpr.autorepairshop.model.dto.VehicleDTO;
import br.edu.utfpr.autorepairshop.model.mapper.VehicleMapper;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import br.edu.utfpr.autorepairshop.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView showFormForUpdate(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView("vehicle/form");

        Optional<Vehicle> optionalVehicle = vehicleService.findById(id);

        if(!optionalVehicle.isPresent()){
            throw new EntityNotFoundException("O veiculo não foi encontrado pelo id informado.");
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

        redirectAttributes.addFlashAttribute("message", "Veículo salvo com sucesso!");
        Vehicle vehicle = vehicleMapper.toEntity(dto);
        vehicle.setId(dto.getRegistration());
        vehicleService.save(vehicle);

        return new ModelAndView("redirect:veiculos");
    }
}
