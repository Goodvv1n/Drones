package ru.goodvvin.drones.data.medicine;

import ru.goodvvin.drones.rest.medicine.MedicineDTO;

import java.util.List;

/**
 * Service for operations with medicines
 */
public interface MedicineService {

	/**
	 * Medicine registration operation
	 * @param dto information about medicine
	 * @return registered medicine information
	 */
	Medicine registerMedicine(MedicineDTO dto);

	/**
	 * Get list of medicines
	 * @return list of medicines
	 */
	List<Medicine> getMedicineList();
}
