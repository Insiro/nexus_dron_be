package com.nexus.drone.drone.repository;

import com.nexus.drone.drone.domain.model.DroneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneTypeRepository extends JpaRepository<DroneType, Long> {
}
