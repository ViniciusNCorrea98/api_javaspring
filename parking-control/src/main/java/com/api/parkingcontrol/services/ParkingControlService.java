package com.api.parkingcontrol.services;

import jakarta.transaction.Transactional;
import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.stereotype.Service;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingControlService {

    //Ele vai injentar dentro de ParkingControlService as depedendicas
    //de ParkingSpotRepository
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingControlService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
}
