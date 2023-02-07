package ru.goodvvin.drones.data.drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository for operations with drone db entities
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {

	/**
	 * Get drone list with state
	 * @param states list of states
	 * @return list of drones
	 */
	List<Drone> findByStateInOrderByIdDesc(List<DroneState> states);

	/**
	 * Update drone battery level
	 * @param droneId drone identifier
	 * @param value charge diff
	 */
	@Modifying
	@Query(value = "update Drone drone set drone.battery = drone.battery + :value where drone.id = :droneId")
	void updateCharging(Long droneId, int value);
}
