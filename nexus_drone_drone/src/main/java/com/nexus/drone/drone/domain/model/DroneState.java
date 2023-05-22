package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class DroneState {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uid;
    @Column
    String desc;
}
