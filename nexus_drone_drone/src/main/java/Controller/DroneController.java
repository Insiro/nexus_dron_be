package Controller;


import Service.DroneService;
import com.nexus.drone.drone.domain.dto.DroneDTO;
import com.nexus.drone.drone.domain.dto.NewDroneRequest;
import com.nexus.drone.drone.domain.dto.UpdateDroneStateRequest;
import com.nexus.drone.drone.domain.model.Drone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/drones")
public class DroneController {

    public final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping
    public ResponseEntity<Iterable<DroneDTO>> getAllDrones() {
        ArrayList<DroneDTO> droneDTOs = new ArrayList<>();
        for (Drone drone : droneService.getAll()) {
            DroneDTO droneDto = DroneDTO.builder().drone(drone).build();
            droneDTOs.add(droneDto);
        }
        return new ResponseEntity<>(droneDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DroneDTO> addDrone(@RequestBody NewDroneRequest newDroneRequest) {
        Drone drone = droneService.newDrone(newDroneRequest);
        DroneDTO droneDTO = DroneDTO.builder().drone(drone).build();
        return new ResponseEntity<>(droneDTO, HttpStatus.OK);
    }
    @GetMapping("{uid}")
    public ResponseEntity<DroneDTO>getDroneInformation(@PathVariable UUID uid){
        Drone drone = droneService.getOne(uid);
        DroneDTO droneDTO =DroneDTO.builder().drone(drone).build();
        return new ResponseEntity<>(droneDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteDrone(@PathVariable UUID uid){
        Drone drone = droneService.getOne(uid);
        droneService.delete(drone);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @PutMapping("{uid}")
    public ResponseEntity<DroneDTO> updateDrone(@PathVariable UUID uid, @RequestBody UpdateDroneStateRequest updateDroneStateRequest){
        Drone drone = droneService.getOne(uid);
        drone = droneService.update(drone,updateDroneStateRequest);
        DroneDTO dto = DroneDTO.builder().drone(drone).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
