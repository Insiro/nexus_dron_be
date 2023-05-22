package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DroneState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long uid;
    @Column
    String desc;
}
