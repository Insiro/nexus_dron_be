package com.nexus.drone.drone.Service;

import com.nexus.drone.drone.domain.dto.Position;
import com.nexus.drone.drone.domain.dto.drone.NewDroneRequest;
import com.nexus.drone.drone.domain.dto.drone.UpdateDroneStateRequest;
import com.nexus.drone.drone.domain.model.Drone;
import com.nexus.drone.drone.repository.DroneRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DroneService {
    final private DroneRepository droneRepository;

    DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public List<Drone> getAll() {
        return droneRepository.findAll();
    }

    public Drone newDrone(NewDroneRequest newDroneRequest) {
        Drone drone = Drone.builder()
                .name(newDroneRequest.getDroneName())
                .modelId(newDroneRequest.getDroneModel())
                .build();
        droneRepository.save(drone);
        return drone;
    }

    public Drone getOne(UUID uid) {
        Optional<Drone> drone = droneRepository.findById(uid);
        return drone.orElseThrow();
    }

    public void delete(Drone drone) {
        droneRepository.delete(drone);
    }

    public Drone update(Drone drone, UpdateDroneStateRequest updateDroneStateRequest) {
        Position position = updateDroneStateRequest.getPosition();
        Date manageDate = updateDroneStateRequest.getManageDate();
        long typeId = updateDroneStateRequest.getTypeId();
        float battery = updateDroneStateRequest.getBattery();
        long state_id = updateDroneStateRequest.getStateId();
        if (position != null)
            drone.setPosition(position);
        if (manageDate != null)
            drone.setManageDate(manageDate);
        if (typeId != 0)
            drone.setTypeId(typeId);
        if (battery != 0f)
            drone.setBattery(battery);
        if (state_id!= 0)
            drone.setStateId(state_id);
        droneRepository.save(drone);
        return drone;
    }
}

