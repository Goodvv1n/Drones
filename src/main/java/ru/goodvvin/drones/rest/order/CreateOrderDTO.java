package ru.goodvvin.drones.rest.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO for create order
 */
@Data
@Builder
@AllArgsConstructor
public class CreateOrderDTO {

	private List<CreateOrderItemDTO> items;

	private Long droneId;
}
