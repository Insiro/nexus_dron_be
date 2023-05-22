package Controller;


import Service.DroneService;
import com.nexus.drone.drone.domain.dto.DroneDTO;
import com.nexus.drone.drone.domain.dto.NewDroneRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(droneService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DroneDTO> addDrone(@RequestBody NewDroneRequestDTO newDroneRequestDTO) {
        return new ResponseEntity<>(droneService.newDrone(newDroneRequestDTO), HttpStatus.OK);
    }
    @GetMapping("{uid}")
    public ResponseEntity<DroneDTO>getDroneInformation(@PathVariable UUID uid){
        return new ResponseEntity<>(droneService.getOne(uid), HttpStatus.CREATED);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteDrone(@PathVariable UUID uid){

        droneService.delete(uid);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
