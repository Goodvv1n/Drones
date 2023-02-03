package ru.goodvvin.drones.data.drone;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goodvvin.drones.rest.drone.DroneRegistrationDTO;

import java.util.List;

/**
 * Implementation of service {@link DroneService}
 */
@Service
@AllArgsConstructor
public class DroneServiceImpl implements DroneService {

	private final DroneRepository repository;

	@Override
	public Drone registration(DroneRegistrationDTO dto) {
		Drone drone = Drone.builder()
			.serial(dto.getSerial())
			.model(dto.getModel())
			.battery(dto.getBattery())
			.weightLimit(dto.getWeightLimit())
			.state(DroneState.IDLE)
			.build();

		return repository.save(drone);
	}

	@Override
	public List<Drone> getDroneList() {
		return repository.findAll();
	}
}
