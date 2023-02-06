package ru.goodvvin.drones.data;

import lombok.NonNull;
import ru.goodvvin.drones.rest.ApiException;
import ru.goodvvin.drones.rest.ErrorCodes;

import java.util.Map;

/**
 * Exception thrown when can't find object in db.
 */
public class ObjectNotFoundException extends ApiException {

	public ObjectNotFoundException(Map<String, ?> details, String message) {
		super(ErrorCodes.OBJECT_NOT_FOUND_ERROR_CODE, details, message);
	}
}
