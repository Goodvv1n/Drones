package ru.goodvvin.drones.rest.drone;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.goodvvin.drones.data.ObjectNotFoundException;
import ru.goodvvin.drones.data.charging.ChargingHistory;
import ru.goodvvin.drones.data.charging.ChargingHistoryService;
import ru.goodvvin.drones.data.drone.Drone;
import ru.goodvvin.drones.data.drone.DroneService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Controller for drone managing
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/drones")
public class DroneController {

	private final DroneService droneService;
	private final ChargingHistoryService chargingHistoryService;

	/**
	 * Get all drones
	 *
	 * @return list of drones
	 */
	@GetMapping
	public ResponseEntity<List<Drone>> getAllDrones() {
		return ResponseEntity.ok(droneService.getDroneList());
	}

	/**
	 * Get drone information
	 *
	 * @param id drone identifier
	 * @return drone information
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Drone> getDroneInfo(@PathVariable Long id) {
		return ResponseEntity.ok(droneService.getDrone(id));
	}

	/**
	 * Get list of available drones
	 *
	 * @return list of available drones
	 */
	@GetMapping("/available")
	public ResponseEntity<List<Drone>> getAvailableDrones() {
		return ResponseEntity.ok(droneService.getAvailableDroneList());
	}

	/**
	 * Registering drones
	 *
	 * @param dto drone data
	 * @return registered drone
	 */
	@PostMapping("/registration")
	public ResponseEntity<Drone> registerDrone(@Validated @RequestBody final DroneRegistrationDTO dto) {
		return ResponseEntity.ok(droneService.registration(dto));
	}

	/**
	 * Get charging history rows
	 *
	 * @param id        drone identifier
	 * @param startDate start date period
	 * @param endDate   end date period
	 * @param pageable  paging parameters
	 * @return charging history rows
	 */
	@GetMapping("/{id}/charging")
	public ResponseEntity<List<ChargingHistory>> getAllDrones(@PathVariable Long id,
															  @Param(value = "startDate") LocalDate startDate,
															  @Param(value = "endDate") LocalDate endDate,
															  @PageableDefault(sort = "id", direction = DESC) final Pageable pageable) {
		return ResponseEntity.ok(chargingHistoryService.getChargingHistoryList(id, startDate, endDate, pageable));
	}
}
