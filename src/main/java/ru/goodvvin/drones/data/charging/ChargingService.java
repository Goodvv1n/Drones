package ru.goodvvin.drones.data.charging;

import ru.goodvvin.drones.data.drone.Drone;

/**
 * Interface of service for charging drones
 */
public interface ChargingService {

	/**
	 * Charging drone
	 *
	 * @param drone drone
	 * @param value charge diff
	 */
	void chargingDrone(Drone drone, int value);

	/**
	 * Expensing charge
	 *
	 * @param drone drone
	 * @param value charge diff
	 */
	void chargeExpense(Drone drone, int value);
}
