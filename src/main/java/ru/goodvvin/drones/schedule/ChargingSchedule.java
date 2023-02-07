package ru.goodvvin.drones.schedule;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.goodvvin.drones.data.charging.ChargingService;
import ru.goodvvin.drones.data.drone.DroneService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling
@AllArgsConstructor
@Slf4j
public class ChargingSchedule {

	private final DroneService droneService;
	private final ChargingService chargingService;

	@Scheduled(cron = "0 */10 * * * *")
	public void changeCharge() {
		log.info(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + ": charging...");
		charging();
		expense();
	}

	private void charging() {
		droneService.getAvailableDroneList()
			.forEach(drone -> chargingService.chargingDrone(drone, 5));
	}

	private void expense() {
		droneService.getMovingDrones()
			.forEach(drone -> chargingService.chargeExpense(drone, 10));
	}

}
