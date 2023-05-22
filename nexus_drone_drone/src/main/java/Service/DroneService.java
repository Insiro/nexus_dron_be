package Service;

import com.nexus.drone.drone.domain.dto.DroneDTO;
import com.nexus.drone.drone.domain.dto.NewDroneRequestDTO;
import com.nexus.drone.drone.domain.model.Drone;
import org.springframework.stereotype.Service;
import repository.DroneRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroneService {
    private DroneRepository droneRepository;

    DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public List<DroneDTO> getAll() {
        List<Drone> drones = droneRepository.findAll();
        ArrayList<DroneDTO> droneDTOs = new ArrayList();
        for (Drone drone : drones) {
            DroneDTO droneDto = DroneDTO.builder().drone(drone).build();
            droneDTOs.add(droneDto);
        }
        return droneDTOs;
    }

    public DroneDTO newDrone(NewDroneRequestDTO newDroneRequestDTO) {
        Drone drone = Drone.builder()
                .name(newDroneRequestDTO.getDroneName())
                .modelId(newDroneRequestDTO.getDroneModel())
                .position(newDroneRequestDTO.getPosition())
                .build();

        droneRepository.save(drone);
        return DroneDTO.builder().drone(drone).build();
    }
}
