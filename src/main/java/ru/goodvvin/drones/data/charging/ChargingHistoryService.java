package ru.goodvvin.drones.data.charging;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface of service for operations with changing history rows
 */
public interface ChargingHistoryService {

	/**
	 * Save charging information
	 *
	 * @param droneId drone identifier
	 * @param level   charging level
	 * @return charging history row
	 */
	ChargingHistory save(Long droneId, int level);

	/**
	 * Get charging history rows
	 *
	 * @param droneId   drone identifier
	 * @param dateStart start time period
	 * @param dateEnd   end time period
	 * @param pageable  pageable parameters
	 * @return
	 */
	List<ChargingHistory> getChargingHistoryList(Long droneId,
												 LocalDate dateStart,
												 LocalDate dateEnd,
												 Pageable pageable);
}
