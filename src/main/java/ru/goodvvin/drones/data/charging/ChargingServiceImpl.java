package ru.goodvvin.drones.data.charging;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goodvvin.drones.data.drone.Drone;
import ru.goodvvin.drones.data.drone.DroneRepository;

@Service
@AllArgsConstructor
public class ChargingServiceImpl implements ChargingService {

	private final DroneRepository droneRepository;
	private final ChargingHistoryService chargingHistoryService;

	@Override
	@Transactional
	public void chargingDrone(Drone drone, int value) {
		if (drone.getBattery() == 100) {
			return;
		}
		int newLevel = drone.getBattery() + value;
		if (newLevel > 100) {
			newLevel = 100;
		}
		droneRepository.updateCharging(drone.getId(), newLevel);
		chargingHistoryService.save(drone.getId(), newLevel);
	}

	@Override
	@Transactional
	public void chargeExpense(Drone drone, int value) {
		if (drone.getBattery() == 0) {
			return;
		}
		int newLevel = drone.getBattery() - value;
		if (newLevel < 0) {
			newLevel = 0;
		}
		droneRepository.updateCharging(drone.getId(), newLevel);
		chargingHistoryService.save(drone.getId(), newLevel);
	}
}
