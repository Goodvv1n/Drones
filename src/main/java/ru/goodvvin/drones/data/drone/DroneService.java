package ru.goodvvin.drones.data.drone;

import ru.goodvvin.drones.rest.drone.DroneRegistrationDTO;

import java.util.List;

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
	 * Get all registered drones
	 * @return list of registered drones
	 */
	List<Drone> getDroneList();
}
