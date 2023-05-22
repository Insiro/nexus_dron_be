package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
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
    @Builder
    DroneModel(String name){
        this.uuid = UUID.randomUUID();
        this.name = name;
    }
}
