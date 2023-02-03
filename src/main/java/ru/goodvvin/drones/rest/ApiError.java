package ru.goodvvin.drones.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class ApiError {

	/**
	 * Builds the error payload form an API exception.
	 *
	 * @param e an API exception.
	 * @return the constructed API error payload.
	 */
	public static ApiError from(final ApiException e) {
		return builder().
			code(e.getCode()).
			message(e.getMessage()).
			details(e.getDetails()).
			build();
	}

	/**
	 * The unique error code for a case.
	 */
	@NonNull
	String code;

	/**
	 * The error message.
	 */
	@NonNull
	String message;

	/**
	 * The error details.
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	Object details;
}
