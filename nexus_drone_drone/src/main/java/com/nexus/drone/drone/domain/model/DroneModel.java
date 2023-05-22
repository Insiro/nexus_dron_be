package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class DroneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    @Column
    String name;
}
