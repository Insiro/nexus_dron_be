package com.nexus.drone.drone.Service;

import com.nexus.drone.drone.domain.dto.model.NewModelRequest;
import com.nexus.drone.drone.domain.dto.model.UpdateModelRequest;
import com.nexus.drone.drone.domain.model.DroneModel;
import com.nexus.drone.drone.repository.DroneModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModelService {
    private final DroneModelRepository repository;
    public ModelService(DroneModelRepository repository){
        this.repository = repository;
    }
    public List<DroneModel> getModels() {
        return repository.findAll();
    }

    public DroneModel newModel(NewModelRequest newModelRequest) {
        DroneModel model =DroneModel.builder().name(newModelRequest.getName()).build();
        return repository.save(model);
    }

    public DroneModel getModel(UUID uid) {
        return repository.findById(uid).orElseThrow();
    }
    public void deleteModel(DroneModel model){
        repository.delete(model);
    }
    public DroneModel updateModel(DroneModel model, UpdateModelRequest updateModelRequest){
        model.setName(updateModelRequest.getName());
        model = repository.save(model);
        return model;
    }

}
