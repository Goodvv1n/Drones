package ru.goodvvin.drones.data.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import ru.goodvvin.drones.data.medicine.Medicine;

/**
 * Order item db entity
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "order_items")
public class OrderItem {

	private static final String ID_SEQUENCE_NAME = "order_item_id_sequence";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQUENCE_NAME)
	@SequenceGenerator(name = ID_SEQUENCE_NAME, sequenceName = ID_SEQUENCE_NAME, allocationSize = 1)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "medicine_id", referencedColumnName = "id", nullable = false)
	private Medicine medicine;

	private Integer count;
}
