package com.nexus.drone.drone.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class DroneType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long uid;
    String name;
}
