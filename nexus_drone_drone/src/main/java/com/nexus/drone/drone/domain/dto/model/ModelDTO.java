package com.nexus.drone.drone.domain.dto.model;

import com.nexus.drone.drone.domain.model.DroneModel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ModelDTO {
    UUID uid;
    String name;
    @Builder
    public ModelDTO(DroneModel model){
        uid = model.getUuid();
        name = model.getName();
    }
}
