package ru.goodvvin.drones.data;

import ru.goodvvin.drones.rest.ApiException;
import ru.goodvvin.drones.rest.ErrorCodes;

import java.util.Map;

/**
 * Exception thrown when catch duplicate entities in db.
 */
public class DuplicateException extends ApiException {

	public DuplicateException(String message, String field) {
		super(ErrorCodes.DUPLICATE_ENTITY_ERROR_CODE, Map.of("value", field), message);
	}


}
