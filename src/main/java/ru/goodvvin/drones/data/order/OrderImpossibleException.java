package ru.goodvvin.drones.data.order;

import lombok.NonNull;
import ru.goodvvin.drones.rest.ApiException;
import ru.goodvvin.drones.rest.ErrorCodes;

import java.util.Map;

/**
 * Exception thrown when can't create order
 */
public class OrderImpossibleException extends ApiException {

	public OrderImpossibleException(Map<String, ?> details, String message) {
		super(ErrorCodes.ORDER_IMPOSSIBLE_ERROR_CODE, details, message);
	}
}
