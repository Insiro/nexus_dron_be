package com.nexus.drone.drone.domain.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class NewDroneRequestDTO {
    String droneName;
    UUID droneModel;
    Position position;
    Date manageDate;
    UUID typeId;
}
