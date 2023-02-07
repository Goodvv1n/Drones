package ru.goodvvin.drones.data.drone;

import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import ru.goodvvin.drones.data.DuplicateException;
import ru.goodvvin.drones.data.ObjectNotFoundException;
import ru.goodvvin.drones.rest.drone.DroneRegistrationDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static ru.goodvvin.drones.data.drone.DroneState.*;

/**
 * Implementation of service {@link DroneService}
 */
@Service
@AllArgsConstructor
public class DroneServiceImpl implements DroneService {

	private final DroneRepository repository;
	private final String CONSTRAINT_NAME = "drones_serial_index";

	private static Map<DroneState, Set<DroneState>> transitions = Map.of(
		IDLE, Set.of(LOADING),
		LOADING, Set.of(LOADED, DELIVERING),
		LOADED, Set.of(DELIVERING),
		DELIVERING, Set.of(DELIVERED),
		DELIVERED, Set.of(RETURNING),
		RETURNING, Set.of(IDLE)
	);

	@Override
	public Drone registration(DroneRegistrationDTO dto) {
		try {
			Drone drone = Drone.builder()
				.serial(dto.getSerial())
				.model(dto.getModel())
				.battery(dto.getBattery())
				.weightLimit(dto.getWeightLimit())
				.state(IDLE)
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
	public Drone getDrone(Long droneId) {
		return repository.findById(droneId)
			.orElseThrow(() -> new ObjectNotFoundException(Map.of("droneId", droneId), "Drone with id did not found"));
	}

	@Override
	public Drone updateState(Drone drone, DroneState state) {
		Drone savingDrone = repository.findById(drone.getId())
			.orElseThrow(() -> new ObjectNotFoundException(Map.of("droneId", drone.getId()), "Drone with id did not found"));
		checkStateTransition(savingDrone, state);

		savingDrone.setState(state);
		return repository.save(savingDrone);
	}

	@Override
	public List<Drone> getDroneList() {
		return repository.findAll();
	}

	@Override
	public List<Drone> getAvailableDroneList() {
		return repository.findByStateInOrderByIdDesc(List.of(IDLE));
	}

	@Override
	public List<Drone> getMovingDrones() {
		return repository.findByStateInOrderByIdDesc(
			List.of(DroneState.DELIVERING, DroneState.DELIVERED, DroneState.RETURNING)
		);
	}

	private void checkStateTransition(Drone drone, DroneState state) {
		if (transitions.get(drone.getState()) == null || !transitions.get(drone.getState()).contains(state)) {
			throw new ImpossibleStateTransitionException(
				Map.of(
					"drone_state", drone.getState().name(),
					"new_state", state.name()),
				"Found incorrect state transition");
		}
	}
}
