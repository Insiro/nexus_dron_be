package com.nexus.drone.drone.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uid;
    @Column
    String name;
    @Column
    float latitude;
    @Column
    float longitude;
    @Column
    float battery; // 0 ~100
    @Column
    Date manage; // pending management date
    @Column
    UUID state; //Drone State id
    @Column
    UUID type; //Drone Type id
    @Column
    UUID model; // model id
}
