package ru.goodvvin.drones.rest.medicine;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.goodvvin.drones.data.drone.Drone;
import ru.goodvvin.drones.data.drone.DroneService;
import ru.goodvvin.drones.data.medicine.Medicine;
import ru.goodvvin.drones.data.medicine.MedicineService;
import ru.goodvvin.drones.rest.drone.DroneRegistrationDTO;

import java.util.List;

/**
 * Controller for medicine managing
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/medicines")
@Tag(name = "Medicine controller", description = "Medicine managing operations")
public class MedicineController {

	private final MedicineService medicineService;

	/**
	 * Get medicine list
	 * @return medicine list
	 */
	@Operation(summary = "Get medicine list")
	@GetMapping
	public ResponseEntity<List<Medicine>> getAllMedicines(){
		return ResponseEntity.ok(medicineService.getMedicineList());
	}

	/**
	 * Registering medicine
	 * @param dto medicine data
	 * @return registered medicine
	 */
	@Operation(summary = "Medicine registration")
	@PostMapping("/registration")
	public ResponseEntity<Medicine> registerDrone(@Validated @RequestBody final MedicineDTO dto) {
		return ResponseEntity.ok(medicineService.registerMedicine(dto));
	}
}
