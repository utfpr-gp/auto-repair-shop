package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.Maintenance;
import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.dto.ClientToFormDTO;
import br.edu.utfpr.autorepairshop.model.dto.MaintenanceDTO;
import br.edu.utfpr.autorepairshop.model.dto.VehicleDTO;
import br.edu.utfpr.autorepairshop.model.mapper.MaintenanceMapper;
import br.edu.utfpr.autorepairshop.model.mapper.VehicleMapper;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import br.edu.utfpr.autorepairshop.model.service.MaintenanceService;
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

@RequestMapping("/atendimentos")
@Controller
public class MaintenanceController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private MaintenanceMapper maintenanceMapper;
    
    @GetMapping
    public ModelAndView index() {
        List<Maintenance> maintenances = maintenanceService.findAll();

        List<MaintenanceDTO> maintenanceDTOs = maintenances.stream()
                .map(s -> maintenanceMapper.toResponseDto(s))
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("maintenance/index");
        mv.addObject("maintenances", maintenanceDTOs);

        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView showForm() {
        List<Vehicle> vehicles = vehicleService.findAll();
        List<VehicleDTO> vehiclesDto = vehicles.stream()
                .map(vehicle -> {
                	VehicleDTO vehicleDto = new VehicleDTO();
                	vehicleDto.setId(vehicle.getId());
                	vehicleDto.setModel(vehicle.getModel());
                	vehicleDto.setPlaca(vehicle.getPlaca());
                    return vehicleDto;
                })
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("maintenance/form");
        mv.addObject("vehiclesDto", vehiclesDto);

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView showFormForUpdate(@PathVariable("id") Long id) {

        Optional<Vehicle> optionalVehicle = vehicleService.findById(id);

        if(!optionalVehicle.isPresent()){
            throw new EntityNotFoundException("O veículo não foi encontrado pelo id informado.");
        } 

        List<Maintenance> maintenances = maintenanceService.findByVehicle(id);

        List<MaintenanceDTO> maintenanceDTOs = maintenances.stream()
                .map(s -> maintenanceMapper.toResponseDto(s))
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("maintenance/index");
        mv.addObject("maintenances", maintenanceDTOs);

        return mv;
    }

    @PostMapping
    public ModelAndView save(@Validated MaintenanceDTO dto, Errors errors, RedirectAttributes redirectAttributes) {
        if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("maintenance/form");
            mv.addObject("dto", dto);
            mv.addObject("errors", errors.getAllErrors());
            return mv;
        }

        redirectAttributes.addFlashAttribute("message", "Manutenção salva com sucesso!");
        Maintenance maintenance = maintenanceMapper.toEntity(dto);
        maintenance.setId(dto.getRegistration());
        maintenanceService.save(maintenance);

        return new ModelAndView("redirect:atendimentos");
    }
}
