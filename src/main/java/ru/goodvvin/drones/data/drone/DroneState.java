package ru.goodvvin.drones.data.drone;

import java.util.Map;
import java.util.Set;

/**
 * Drone states list
 */
public enum DroneState {

	IDLE,
	LOADING,
	LOADED,
	DELIVERING,
	DELIVERED,
	RETURNING;
}
