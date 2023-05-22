package com.nexus.drone.drone.domain.dto.drone;

import com.nexus.drone.drone.domain.dto.Position;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateDroneStateRequest {
    float battery;
    long stateId;
    long typeId;
    Position position;
    Date manageDate;

}
