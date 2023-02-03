package ru.goodvvin.drones.rest;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.goodvvin.drones.data.drone.DroneModel;

/**
 * DTO for dron registration operation
 */
@Data
public class DroneRegistrationDTO {

	@Size(max = 100, message = "Serial number too long")
	private String serial;

	@Enumerated(EnumType.STRING)
	private DroneModel model;

	@Min(1)
	@Max(500)
	private int weightLimit;

	@Min(1)
	@Max(100)
	private int battery;
}
