package com.api.parkingcontrol.controllers;


import com.api.parkingcontrol.dto.ParkingSpotDto;
import jakarta.validation.Valid;
import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.parkingcontrol.services.ParkingControlService;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    //Criando um ponto de injeção de ParkingControlService
    //em ParkingSpotController

    final
    ParkingControlService parkingControlService;

    public ParkingSpotController(ParkingControlService parkingControlService) {
        this.parkingControlService = parkingControlService;
    }

    @PostMapping
    public ResponseEntity <Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpotModel = new ParkingSpotModel();

        //Convertando DTO em Model
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(String.valueOf(LocalDateTime.now(ZoneId.of("UTC"))));


        return ResponseEntity.status(HttpStatus.CREATED).body(parkingControlService.save(parkingSpotModel));
    }
}
