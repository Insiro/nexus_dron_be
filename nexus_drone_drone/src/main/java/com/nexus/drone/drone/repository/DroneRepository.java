package com.nexus.drone.drone.repository;

import com.nexus.drone.drone.domain.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DroneRepository extends JpaRepository<Drone, UUID> {
}
