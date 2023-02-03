package ru.goodvvin.drones.data.drone;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for operations with drone db entities
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {
}
