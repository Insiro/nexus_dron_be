package Service;

import com.nexus.drone.drone.domain.dto.NewDroneRequest;
import com.nexus.drone.drone.domain.dto.Position;
import com.nexus.drone.drone.domain.dto.UpdateDroneStateRequest;
import com.nexus.drone.drone.domain.model.Drone;
import org.springframework.stereotype.Service;
import repository.DroneRepository;

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
        return drone.get();
    }

    public void delete(Drone drone) {
        droneRepository.delete(drone);
    }

    public Drone update(Drone drone, UpdateDroneStateRequest updateDroneStateRequest) {
        Position position = updateDroneStateRequest.getPosition();
        if (position != null)
            drone.setPosition(position);
        Date manageDate = updateDroneStateRequest.getManageDate();
        if (manageDate != null)
            drone.setManageDate(manageDate);
        drone.setTypeId(updateDroneStateRequest.getTypeId());
        drone.setBattery(updateDroneStateRequest.getBattery());
        drone.setStateId(updateDroneStateRequest.getStateId());
        droneRepository.save(drone);
        return drone;
    }
}
