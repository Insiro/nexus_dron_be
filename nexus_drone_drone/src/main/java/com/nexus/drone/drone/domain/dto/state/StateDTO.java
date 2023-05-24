package com.nexus.drone.drone.domain.dto.state;

import com.nexus.drone.drone.domain.model.DroneState;
import lombok.Builder;
import lombok.Data;

@Data
public class StateDTO {
    long uid;
    String name;
    @Builder
    StateDTO(DroneState state){
        uid = state.getUid();
        name= state.getName();
    }
}
