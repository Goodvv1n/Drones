package ru.goodvvin.drones.data.drone;

import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import ru.goodvvin.drones.data.DuplicateException;
import ru.goodvvin.drones.rest.drone.DroneRegistrationDTO;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of service {@link DroneService}
 */
@Service
@AllArgsConstructor
public class DroneServiceImpl implements DroneService {

	private final DroneRepository repository;
	private final String CONSTRAINT_NAME = "drones_serial_index";

	@Override
	public Drone registration(DroneRegistrationDTO dto) {
		try {
			Drone drone = Drone.builder()
				.serial(dto.getSerial())
				.model(dto.getModel())
				.battery(dto.getBattery())
				.weightLimit(dto.getWeightLimit())
				.state(DroneState.IDLE)
				.build();

			return repository.save(drone);
		} catch (Exception ex) {
			if (ex.getCause() instanceof ConstraintViolationException && ex.getMessage().contains(CONSTRAINT_NAME)) {
				throw new DuplicateException("Drone with that serial already registered", dto.getSerial());
			} else
				throw ex;
		}
	}

	@Override
	public Optional<Drone> findDrone(Long droneId) {
		return repository.findById(droneId);
	}

	@Override
	public Drone updateState(Drone drone, DroneState state) {
		Drone savingDrone = repository.findById(drone.getId()).get();
		savingDrone.setState(state);
		return repository.save(savingDrone);
	}

	@Override
	public List<Drone> getDroneList() {
		return repository.findAll();
	}

	@Override
	public List<Drone> getAvailableDroneList() {
		return repository.findByStateOrderByIdDesc(DroneState.IDLE);
	}
}
