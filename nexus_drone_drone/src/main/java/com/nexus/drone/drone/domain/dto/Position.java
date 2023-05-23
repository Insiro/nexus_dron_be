package com.nexus.drone.drone.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position{
    float latitude;
    float longitude;
}
