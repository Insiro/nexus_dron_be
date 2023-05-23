package com.nexus.drone.drone.Controller;

import com.nexus.drone.drone.Service.TypeService;
import com.nexus.drone.drone.domain.dto.type.NewTypeDTO;
import com.nexus.drone.drone.domain.dto.type.TypeDTO;
import com.nexus.drone.drone.domain.model.DroneType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/drones/states")
public class TypeController {
    public final TypeService service;

    public TypeController(TypeService Service) {
        this.service = Service;
    }

    @GetMapping
    public ResponseEntity<Iterable<TypeDTO>> getAllDrones() {
        ArrayList<TypeDTO> stateDTOS = new ArrayList<>();
        for (DroneType type : service.getModels()) {
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
    public ResponseEntity<TypeDTO>getDroneInformation(@PathVariable UUID uid){
        DroneType type = service.getState(uid);
        TypeDTO stateDTO =TypeDTO.builder().type(type).build();
        return new ResponseEntity<>(stateDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteDrone(@PathVariable UUID uid){
        DroneType type = service.getState(uid);
        service.delete(type);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @PutMapping("{uid}")
    public ResponseEntity<TypeDTO> updateDrone(@PathVariable UUID uid, @RequestBody NewTypeDTO newStateRequest){
        DroneType type = service.getState(uid);
        type = service.update(type,newStateRequest);
        TypeDTO dto = TypeDTO.builder().type(type).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
