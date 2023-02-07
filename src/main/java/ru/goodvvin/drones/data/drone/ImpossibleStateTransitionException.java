package ru.goodvvin.drones.data.drone;

import lombok.NonNull;
import ru.goodvvin.drones.rest.ApiException;
import ru.goodvvin.drones.rest.ErrorCodes;

import java.util.Map;

/**
 * Exception thrown when find incorrect state transition
 */
public class ImpossibleStateTransitionException extends ApiException {

	public ImpossibleStateTransitionException(Map<String, ?> details, String message) {
		super(ErrorCodes.IMPOSSIBLE_STATE_TRANSITION_ERROR_CODE, details, message);
	}
}
