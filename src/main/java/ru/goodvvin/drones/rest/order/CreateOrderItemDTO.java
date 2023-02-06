package ru.goodvvin.drones.rest.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for create order item
 */
@Data
@Builder
@AllArgsConstructor
public class CreateOrderItemDTO {

	private Long medicineId;

	private Integer count;
}
