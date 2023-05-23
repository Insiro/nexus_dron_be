package com.nexus.drone.drone.Controller;

import com.nexus.drone.drone.Service.ModelService;
import com.nexus.drone.drone.domain.dto.model.ModelDTO;
import com.nexus.drone.drone.domain.dto.model.NewModelRequest;
import com.nexus.drone.drone.domain.dto.model.UpdateModelRequest;
import com.nexus.drone.drone.domain.model.DroneModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/drones/models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<ModelDTO>> getModels() {
        Iterable<DroneModel> models = modelService.getModels();
        ArrayList<ModelDTO> modelDTOs = new ArrayList<>();
        for (DroneModel model : models) {
            ModelDTO dto = ModelDTO.builder().model(model).build();
            modelDTOs.add(dto);
        }
        return new ResponseEntity<>(modelDTOs, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<ModelDTO> newModel(@RequestBody NewModelRequest newModelRequest){
        DroneModel droneModel = modelService.newModel(newModelRequest);
        ModelDTO dto = ModelDTO.builder().model(droneModel).build();
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("{uid}")
    public ResponseEntity<ModelDTO> getModel(@PathVariable UUID uid){
        DroneModel model = modelService.getModel(uid);
        ModelDTO dto = ModelDTO.builder().model(model).build();
        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteModel(@PathVariable UUID uid){
        DroneModel model = modelService.getModel(uid);
        modelService.deleteModel(model);
        return  new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PutMapping("{uid}")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable UUID uid, @RequestBody UpdateModelRequest updateModelRequest) {
        DroneModel model = modelService.getModel(uid);
        model = modelService.updateModel(model, updateModelRequest);
        ModelDTO dto = ModelDTO.builder().model(model).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
