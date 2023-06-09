package com.nexus.drone.drone.Controller;

import com.nexus.drone.drone.Service.StateService;
import com.nexus.drone.drone.domain.dto.state.NewStateRequest;
import com.nexus.drone.drone.domain.dto.state.StateDTO;
import com.nexus.drone.drone.domain.model.DroneState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/drones/states")
public class StateController {
    public final StateService service;

    public StateController(StateService Service) {
        this.service = Service;
    }

    @GetMapping
    public ResponseEntity<Iterable<StateDTO>> getAllStates() {
        ArrayList<StateDTO> stateDTOS = new ArrayList<>();
        for (DroneState state : service.getModels()) {
            StateDTO droneDto = StateDTO.builder().state(state).build();
            stateDTOS.add(droneDto);
        }
        return new ResponseEntity<>(stateDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StateDTO> addState(@RequestBody NewStateRequest newStateRequest) {
        DroneState state = service.newState(newStateRequest);
        StateDTO stateDTO =StateDTO.builder().state(state).build();
        return new ResponseEntity<>(stateDTO, HttpStatus.OK);
    }
    @GetMapping("{uid}")
    public ResponseEntity<StateDTO>getStateInformation(@PathVariable Long uid){
        DroneState state = service.getState(uid);
        StateDTO stateDTO =StateDTO.builder().state(state).build();
        return new ResponseEntity<>(stateDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteState(@PathVariable Long uid){
        DroneState state = service.getState(uid);
        service.delete(state);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @PutMapping("{uid}")
    public ResponseEntity<StateDTO> updateState(@PathVariable Long uid, @RequestBody NewStateRequest newStateRequest){
        DroneState state = service.getState(uid);
        state = service.update(state,newStateRequest);
        StateDTO dto = StateDTO.builder().state(state).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
