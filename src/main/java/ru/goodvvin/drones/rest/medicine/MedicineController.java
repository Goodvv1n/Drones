package ru.goodvvin.drones.rest.medicine;

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
@RequestMapping("/api/medicine")
public class MedicineController {

	private final MedicineService medicineService;

	@GetMapping("/all")
	public ResponseEntity<List<Medicine>> getAllDrones(){
		return ResponseEntity.ok(medicineService.getMedicineList());
	}

	@PostMapping("/registration")
	public ResponseEntity<Medicine> registerDrone(@Validated @RequestBody final MedicineDTO dto) {
		return ResponseEntity.ok(medicineService.registerMedicine(dto));
	}
}
