package ru.goodvvin.drones.rest.order;

import lombok.*;
import ru.goodvvin.drones.data.drone.DroneState;

/**
 * DTO for changing state
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderStateDTO {

	private DroneState state;
}
