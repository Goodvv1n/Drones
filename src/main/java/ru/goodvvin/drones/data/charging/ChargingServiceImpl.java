package ru.goodvvin.drones.data.charging;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goodvvin.drones.data.drone.DroneRepository;

@Service
@AllArgsConstructor
public class ChargingServiceImpl implements ChargingService {

	private final DroneRepository droneRepository;

	@Override
	@Transactional
	public void chargingDrone(Long droneId, int value) {
		droneRepository.updateCharging(droneId, value);
	}

	@Override
	@Transactional
	public void chargeExpense(Long droneId, int value) {
		droneRepository.updateCharging(droneId, value * -1);
	}
}
