package ru.goodvvin.drones.rest.medicine;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Medicine dto
 */
@Data
@NoArgsConstructor
public class MedicineDTO {

	@Pattern(regexp = "[0-9a-zA-Z-_]*", message = "Name must have only letters, numbers, ‘-‘, ‘_’")
	private String name;

	@Max(value = 1000, message = "Weight must be less than 1000g")
	private int weight;

	@Pattern(regexp = "[0-9A-Z_]*", message = "Name must have only upper case letters, underscore and numbers")
	private String code;

	private String image;
}
