package ru.goodvvin.drones.schedule;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.goodvvin.drones.data.charging.ChargingService;
import ru.goodvvin.drones.data.drone.DroneService;

@Component
@EnableScheduling
@AllArgsConstructor
public class ChargingSchedule {

	private final DroneService droneService;
	private final ChargingService chargingService;

	@Scheduled(cron = "0 */5 * * * *")
	public void changeCharge(){
		charging();
		expense();
	}

	private void charging() {
		droneService.getAvailableDroneList()
			.forEach(drone -> chargingService.chargingDrone(drone.getId(), 5));
	}

	private void expense() {
		droneService.getMovingDrones()
			.forEach(drone -> chargingService.chargeExpense(drone.getId(), 10));
	}

}
