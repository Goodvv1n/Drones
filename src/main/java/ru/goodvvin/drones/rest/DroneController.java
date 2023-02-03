package ru.goodvvin.drones.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.goodvvin.drones.data.drone.Drone;
import ru.goodvvin.drones.data.drone.DroneService;

import java.util.List;

/**
 * Controller for drone managing
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DroneController {

	private final DroneService droneService;

	@GetMapping("/drone/all")
	public ResponseEntity<List<Drone>> getAllDrones(){
		return ResponseEntity.ok(droneService.getDroneList());
	}

	@PostMapping("/drone/registration")
	public ResponseEntity<Drone> registerDrone(@Validated @RequestBody final DroneRegistrationDTO dto) {
		return ResponseEntity.ok(droneService.registration(dto));
	}
}
