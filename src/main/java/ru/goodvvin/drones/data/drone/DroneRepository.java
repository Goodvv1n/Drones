package ru.goodvvin.drones.data.drone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for operations with drone db entities
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {

	/**
	 * Get drone list with state
	 * @param state state
	 * @return list of drones
	 */
	List<Drone> findByStateOrderByIdDesc(DroneState state);
}
