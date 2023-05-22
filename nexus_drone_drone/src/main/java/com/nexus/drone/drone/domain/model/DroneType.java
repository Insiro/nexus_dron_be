package com.nexus.drone.drone.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity
public class DroneType {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    UUID uid;
    String name;
}
