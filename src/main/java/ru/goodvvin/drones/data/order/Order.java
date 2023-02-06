package ru.goodvvin.drones.data.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.goodvvin.drones.data.drone.Drone;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * Order db entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "orders")
public class Order {

	private static final String ID_SEQUENCE_NAME = "order_id_sequence";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQUENCE_NAME)
	@SequenceGenerator(name = ID_SEQUENCE_NAME, sequenceName = ID_SEQUENCE_NAME, allocationSize = 1)
	private Long id;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private List<OrderItem> items;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drone_id", referencedColumnName = "id", nullable = false)
	private Drone drone;
}
