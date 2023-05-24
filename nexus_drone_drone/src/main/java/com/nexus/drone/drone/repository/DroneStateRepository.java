package com.nexus.drone.drone.repository;

import com.nexus.drone.drone.domain.model.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DroneStateRepository extends JpaRepository<DroneState, Long> {
}
