package ru.goodvvin.drones;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.goodvvin.drones.rest.ApiError;
import ru.goodvvin.drones.rest.ErrorCodes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.data.util.CastUtils.cast;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(BAD_REQUEST)
	public ApiError handleBindException(final MethodArgumentNotValidException ex) {
		final PropertyNamingStrategies.NamingBase namingStrategy = cast(PropertyNamingStrategies.SNAKE_CASE);
		return ApiError.builder().
			code(ErrorCodes.INVALID_INPUT_ERROR_CODE).
			message("The given parameter is invalid").
			details(InvalidParameter.builder().
				parameter(ex.getParameter().getParameterName()).
				fields(ex.getBindingResult().
					getFieldErrors().
					stream().
					map(e -> InvalidField.builder().
						name(namingStrategy.translate(e.getField())).
						value(Objects.toString(e.getRejectedValue())).
						message(e.getDefaultMessage()).
						build()).
					collect(Collectors.toList())).
				build()).
			build();
//		return ex.getMessage();
	}

	/**
	 * Describes an invalid parameter.
	 */
	@Value
	@Builder
	public static class InvalidParameter {
		/**
		 * The parameter name.
		 */
		String parameter;

		/**
		 * The list of the invalid fields.
		 */
		List<InvalidField> fields;
	}

	/**
	 * Describes an invalid field.
	 */
	@Value
	@Builder
	public static class InvalidField {
		/**
		 * The field name.
		 */
		@NonNull
		String name;

		/**
		 * The passed value.
		 */
		String value;

		/**
		 * The validation message.
		 */
		String message;
	}
}
