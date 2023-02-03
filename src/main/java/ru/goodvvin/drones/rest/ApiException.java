package ru.goodvvin.drones.rest;

import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

/**
 * Base class for all business related exceptions by the API.
 */
public abstract class ApiException extends RuntimeException {
	/**
	 * The specific error code for a business case.
	 */
	@Getter
	private final String code;

	/**
	 * The detail information.
	 */
	@Getter
	private final Map<String, ?> details;

	/**
	 * Constructs an instance with the predefined properties.
	 *
	 * @param code    the specific error code for a business case.
	 * @param details the detail information.
	 * @param message the error message.
	 */
	public ApiException(@NonNull String code, Map<String, ?> details, String message) {
		super(message);

		this.code = code;
		this.details = details;
	}

	/**
	 * Constructs an instance with the predefined properties.
	 *
	 * @param code    the specific error code for a business case.
	 * @param details the detail information.
	 * @param message the error message.
	 * @param cause   cause of error
	 */
	public ApiException(@NonNull String code, Map<String, ?> details, String message, Throwable cause) {
		super(message, cause);

		this.code = code;
		this.details = details;
	}
}
