package ru.goodvvin.drones.data.charging;

import ru.goodvvin.drones.data.drone.Drone;

/**
 * Interface of service for charging drones
 */
public interface ChargingService {

	/**
	 * Charging drone
	 * @param droneId drone identifier
	 * @param value charge diff
	 */
	void chargingDrone(Long droneId, int value);

	/**
	 * Expensing charge
	 * @param droneId drone identifier
	 * @param value charge diff
	 */
	void chargeExpense(Long droneId, int value);
}
