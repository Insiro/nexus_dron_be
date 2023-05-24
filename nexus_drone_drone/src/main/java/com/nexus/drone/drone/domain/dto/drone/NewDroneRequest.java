package com.nexus.drone.drone.domain.dto.drone;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class NewDroneRequest {
    String droneName;
    UUID droneModel;
    Date manageDate;
    long typeId;
}
