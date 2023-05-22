package com.nexus.drone.drone.domain.model;

import com.nexus.drone.drone.domain.dto.Position;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
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
    Date manageDate; // pending management date
    @Column
    long stateId; //Drone State id
    @Column
    long typeId; //Drone Type id
    @Column
    UUID modelId; // model id
    @Builder
    Drone(String name, UUID modelId){
        this.uid = UUID.randomUUID();
        this.name = name;
        this.longitude = 0f;
        this.latitude = 0f;
        this.battery = 100f;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        this.manageDate = cal.getTime();
        this.stateId =0;
        this.modelId = modelId;
    }

    public Position getPosition(){
        return new Position(latitude, longitude);
    }

    public void setPosition(Position position){
        this.latitude = position.getLatitude();
        this.longitude = position.getLongitude();
    }
}
