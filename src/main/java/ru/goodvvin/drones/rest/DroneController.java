package ru.goodvvin.drones.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goodvvin.drones.data.DroneRepository;

@RestController
@RequestMapping("/api")
public class DroneController {

	@Autowired
	private DroneRepository repository;

	@GetMapping("/check")
	public ResponseEntity<String> check(){
		long count = repository.count();
		return ResponseEntity.ok(count + " working...");
	}
}
