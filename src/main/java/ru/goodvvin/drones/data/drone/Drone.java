package ru.goodvvin.drones.data.drone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Drone db entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drones")
public class Drone {

	private static final String ID_SEQUENCE_NAME = "drones_id_sequence";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQUENCE_NAME)
	@SequenceGenerator(name = ID_SEQUENCE_NAME, sequenceName = ID_SEQUENCE_NAME, allocationSize = 1)
	private Long id;

	private String serial;

	@Enumerated(EnumType.STRING)
	private DroneModel model;

	private int weightLimit;

	private int battery;

	@Enumerated(EnumType.STRING)
	private DroneState state;
}
