package ru.goodvvin.drones.rest.drone;

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

	@Min(value = 1, message = "The weight limit must be in the range from 1 to 500")
	@Max(value = 500, message = "The weight limit must be in the range from 1 to 500")
	private int weightLimit;

	@Min(value = 0, message = "Battery capacity must be in the range from 0 to 100")
	@Max(value = 100, message = "Battery capacity must be in the range from 0 to 100")
	private int battery;
}
