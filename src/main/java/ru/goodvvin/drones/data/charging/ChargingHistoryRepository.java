package ru.goodvvin.drones.data.charging;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository for operations with charging history rows
 */
public interface ChargingHistoryRepository extends JpaRepository<ChargingHistory, Long> {

	/**
	 * Get charging history by drone identifier
	 *
	 * @param droneId  drone identifier
	 * @param pageable paging parameters
	 * @return charging history
	 */
	List<ChargingHistory> findByDroneIdAndCreatedAtBetweenOrderByIdDesc(Long droneId, LocalDateTime timeStart, LocalDateTime timeEnd, Pageable pageable);
}
