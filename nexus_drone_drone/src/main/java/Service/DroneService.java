package Service;

import com.nexus.drone.drone.domain.dto.DroneDTO;
import com.nexus.drone.drone.domain.dto.NewDroneRequestDTO;
import com.nexus.drone.drone.domain.model.Drone;
import org.springframework.stereotype.Service;
import repository.DroneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DroneService {
    final private DroneRepository droneRepository;

    DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    protected Drone loadOne(UUID uid) {
        Optional<Drone> drone = droneRepository.findById(uid);
        return drone.get();
    }

    protected void deleteOne(Drone drone) {
        droneRepository.delete(drone);
    }

    public List<DroneDTO> getAll() {
        List<Drone> drones = droneRepository.findAll();
        ArrayList<DroneDTO> droneDTOs = new ArrayList<>();
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

    public DroneDTO getOne(UUID uid) {
        return DroneDTO.builder().drone(loadOne(uid)).build();
    }


    public void delete(UUID uid) {
        Drone drone = loadOne(uid);
        deleteOne(drone);
    }
}
