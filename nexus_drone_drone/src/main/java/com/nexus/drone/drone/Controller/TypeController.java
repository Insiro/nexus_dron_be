package com.nexus.drone.drone.Controller;

import com.nexus.drone.drone.Service.TypeService;
import com.nexus.drone.drone.domain.dto.type.NewTypeDTO;
import com.nexus.drone.drone.domain.dto.type.TypeDTO;
import com.nexus.drone.drone.domain.model.DroneType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/drones/types")
public class TypeController {
    public final TypeService service;

    public TypeController(TypeService Service) {
        this.service = Service;
    }

    @GetMapping
    public ResponseEntity<Iterable<TypeDTO>> getAllDrones() {
        ArrayList<TypeDTO> stateDTOS = new ArrayList<>();
        for (DroneType type : service.getAll()) {
            TypeDTO dto = TypeDTO.builder().type(type).build();
            stateDTOS.add(dto);
        }
        return new ResponseEntity<>(stateDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeDTO> addDrone(@RequestBody NewTypeDTO newStateRequest) {
        DroneType type = service.newState(newStateRequest);
        TypeDTO stateDTO =TypeDTO.builder().type(type).build();
        return new ResponseEntity<>(stateDTO, HttpStatus.OK);
    }
    @GetMapping("{uid}")
    public ResponseEntity<TypeDTO>getDroneInformation(@PathVariable Long uid){
        DroneType type = service.getType(uid);
        TypeDTO stateDTO =TypeDTO.builder().type(type).build();
        return new ResponseEntity<>(stateDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteDrone(@PathVariable Long uid){
        DroneType type = service.getType(uid);
        service.delete(type);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @PutMapping("{uid}")
    public ResponseEntity<TypeDTO> updateDrone(@PathVariable Long uid, @RequestBody NewTypeDTO newStateRequest){
        DroneType type = service.getType(uid);
        type = service.update(type,newStateRequest);
        TypeDTO dto = TypeDTO.builder().type(type).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
