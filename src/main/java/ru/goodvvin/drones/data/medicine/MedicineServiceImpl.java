package ru.goodvvin.drones.data.medicine;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goodvvin.drones.rest.medicine.MedicineDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

	private final MedicineRepository repository;

	@Override
	public Medicine registerMedicine(MedicineDTO dto) {
		Medicine medicine = Medicine.builder()
			.code(dto.getCode())
			.weight(dto.getWeight())
			.name(dto.getName())
			.image(dto.getImage())
			.build();

		return repository.save(medicine);
	}

	@Override
	public List<Medicine> getMedicineList() {
		return repository.findAll();
	}
}
