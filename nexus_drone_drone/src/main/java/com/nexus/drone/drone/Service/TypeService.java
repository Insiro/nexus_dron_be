package com.nexus.drone.drone.Service;


import com.nexus.drone.drone.domain.dto.type.NewTypeDTO;
import com.nexus.drone.drone.domain.model.DroneType;
import com.nexus.drone.drone.repository.DroneTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TypeService {
    private final DroneTypeRepository repository;
    TypeService(DroneTypeRepository repository){
        this.repository = repository;
    }
    public List<DroneType> getModels() {
        return repository.findAll();
    }

    public DroneType newState(NewTypeDTO newTypeDTO) {
        DroneType model =DroneType.builder().name(newTypeDTO.getName()).build();
        return repository.save(model);
    }

    public DroneType getState(UUID uid) {
        return repository.findById(uid).orElseThrow();
    }
    public void delete(DroneType model){
        repository.delete(model);
    }
    public DroneType update(DroneType state, NewTypeDTO newTypeDTO){
        state.setName(newTypeDTO.getName());
        state = repository.save(state);
        return state;
    }

}
