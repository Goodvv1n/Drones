package ru.goodvvin.drones.data.drone;

import ru.goodvvin.drones.rest.drone.DroneRegistrationDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interface of service for drone managing
 */
public interface DroneService {

	/**
	 * Drone registration operation
	 * @param dto information about drone
	 * @return registered drone information
	 */
	Drone registration(DroneRegistrationDTO dto);

	/**
	 * Find drone by identifier
	 * @param droneId drone identifier
	 * @return drone
	 */
	Optional<Drone> findDrone(Long droneId);

	/**
	 * Update drone state
	 * @param drone drone
	 * @param newState new drone state
	 */
	Drone updateState(Drone drone, DroneState newState);

	/**
	 * Get all registered drones
	 * @return list of registered drones
	 */
	List<Drone> getDroneList();
}
