package ru.goodvvin.drones.data.charging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.goodvvin.drones.data.drone.Drone;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "charging_history")
public class ChargingHistory {

	private static final String ID_SEQUENCE_NAME = "charging_history_id_sequence";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQUENCE_NAME)
	@SequenceGenerator(name = ID_SEQUENCE_NAME, sequenceName = ID_SEQUENCE_NAME, allocationSize = 1)
	private Long id;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "drone_id", nullable = false)
	private Long droneId;

	private int level;
}
