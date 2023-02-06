package ru.goodvvin.drones.rest.drone;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.goodvvin.drones.data.ObjectNotFoundException;
import ru.goodvvin.drones.data.drone.Drone;
import ru.goodvvin.drones.data.drone.DroneService;

import java.util.List;

/**
 * Controller for drone managing
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/drones")
public class DroneController {

	private final DroneService droneService;

	/**
	 * Get all drones
	 * @return list of drones
	 */
	@GetMapping
	public ResponseEntity<List<Drone>> getAllDrones(){
		return ResponseEntity.ok(droneService.getDroneList());
	}

	/**
	 * Get drone information
	 * @param id drone identifier
	 * @return drone information
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Drone> getDroneInfo(@PathVariable Long id){
		return ResponseEntity.ok(droneService.getDrone(id));
	}

	/**
	 * Get list of available drones
	 * @return list of available drones
	 */
	@GetMapping("/available")
	public ResponseEntity<List<Drone>> getAvailableDrones(){
		return ResponseEntity.ok(droneService.getAvailableDroneList());
	}

	/**
	 * Registering drones
	 * @param dto drone data
	 * @return registered drone
	 */
	@PostMapping("/registration")
	public ResponseEntity<Drone> registerDrone(@Validated @RequestBody final DroneRegistrationDTO dto) {
		return ResponseEntity.ok(droneService.registration(dto));
	}
}
