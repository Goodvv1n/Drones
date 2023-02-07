package ru.goodvvin.drones.rest;

import lombok.experimental.UtilityClass;

/**
 * The possible codes of errors
 */
@UtilityClass
public class ErrorCodes {

	public String INVALID_INPUT_ERROR_CODE = "INVALID_INPUT";

	public String DUPLICATE_ENTITY_ERROR_CODE = "DUPLICATE_ENTITY";

	public String OBJECT_NOT_FOUND_ERROR_CODE = "OBJECT_NOT_FOUND";

	public String ORDER_IMPOSSIBLE_ERROR_CODE = "ORDER_IMPOSSIBLE";

	public String IMPOSSIBLE_STATE_TRANSITION_ERROR_CODE = "IMPOSSIBLE_STATE_TRANSITION";
}
