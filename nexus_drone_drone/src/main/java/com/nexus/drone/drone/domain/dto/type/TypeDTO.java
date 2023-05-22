package com.nexus.drone.drone.domain.dto.type;

import com.nexus.drone.drone.domain.model.DroneType;
import lombok.Builder;
import lombok.Data;

@Data
public class TypeDTO {
    String name;
    Long uid;
    @Builder
    TypeDTO(DroneType type){
        name = type.getName();
        uid = type.getUid();
    }
}
