package com.nexus.drone.drone.Service;


import com.nexus.drone.drone.domain.dto.state.NewStateRequest;
import com.nexus.drone.drone.domain.model.DroneState;
import com.nexus.drone.drone.repository.DroneStateRepository;
import com.nexus.drone.drone.utils.HttpError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    private final DroneStateRepository repository;
    public StateService(DroneStateRepository repository){
        this.repository = repository;
    }
    public List<DroneState> getModels() {
        return repository.findAll();
    }

    public DroneState newState(NewStateRequest newStateRequest) {
        DroneState model =DroneState.builder().name(newStateRequest.getName()).build();
        return repository.save(model);
    }

    public DroneState getState(Long uid) {
        return repository.findById(uid).orElseThrow();
    }
    public void delete(DroneState model){
        repository.delete(model);
    }
    public DroneState update(DroneState model, NewStateRequest newStateRequest) throws HttpError{
        if (model.getUid() <8)
            throw  new HttpError(HttpStatus.FORBIDDEN);
        model.setName(newStateRequest.getName());
        model = repository.save(model);
        return model;
    }

}
