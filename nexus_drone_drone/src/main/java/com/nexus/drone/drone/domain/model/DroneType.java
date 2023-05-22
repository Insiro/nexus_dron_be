package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class DroneType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long uid;
    @Column
    String name;

    @Builder
    DroneType(String name) {
        this.name = name;
    }
}
