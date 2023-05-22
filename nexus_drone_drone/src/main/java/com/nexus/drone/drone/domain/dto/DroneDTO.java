package com.nexus.drone.drone.domain.dto;

import com.nexus.drone.drone.domain.model.Drone;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DroneDTO {
    UUID uid;
    String name;
    Position position;
    float battery; // 0 ~100
    Date manageDate; // pending management date
    long stateId; //Drone State id
    long typeId; //Drone Type id
    UUID modelId; // model id
    @Builder
    public DroneDTO(Drone drone){
        this.uid = drone.getUid();
        this.name= drone.getName();
        this.position = drone.getPosition();
        this.manageDate = drone.getManageDate();
        this.stateId = drone.getStateId();
        this.typeId = drone.getTypeId();
        this.modelId = drone.getModelId();
    }

}
