package br.edu.utfpr.autorepairshop.service;

import br.edu.utfpr.autorepairshop.model.Vehicle;
import br.edu.utfpr.autorepairshop.model.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }

    public Vehicle save(Vehicle vehicle){

        return vehicleRepository.save(vehicle);
    }

    public byte[] convertPhoto(MultipartFile file){
        try {
            return Base64.getEncoder().encode(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
