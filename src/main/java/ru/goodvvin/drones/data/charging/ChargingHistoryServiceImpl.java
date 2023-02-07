package ru.goodvvin.drones.data.charging;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ChargingHistoryServiceImpl implements ChargingHistoryService {

	private final ChargingHistoryRepository repository;

	@Override
	public ChargingHistory save(Long droneId, int level) {
		return repository.save(
			ChargingHistory.builder()
				.droneId(droneId)
				.level(level)
				.build()
		);
	}

	@Override
	public List<ChargingHistory> getChargingHistoryList(Long droneId,
														LocalDate dateStart,
														LocalDate dateEnd,
														Pageable pageable) {
		return repository.findByDroneIdAndCreatedAtBetweenOrderByIdDesc(
			droneId,
			LocalDateTime.of(dateStart, LocalTime.MIN),
			LocalDateTime.of(dateEnd, LocalTime.MAX),
			pageable);
	}
}
