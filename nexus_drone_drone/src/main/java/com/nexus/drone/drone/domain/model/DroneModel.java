package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class DroneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    @Column
    String name;
}
