package ru.goodvvin.drones.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drones")
public class Drone {

	@Id
	private Long id;

	private String name;
}
