package ru.goodvvin.drones.data.medicine;

import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import ru.goodvvin.drones.data.DuplicateException;
import ru.goodvvin.drones.rest.medicine.MedicineDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

	private final MedicineRepository repository;
	private final String CONSTRAINT_NAME = "medicine_code_index";

	@Override
	public Medicine registerMedicine(MedicineDTO dto) {
		try {
			Medicine medicine = Medicine.builder()
				.code(dto.getCode())
				.weight(dto.getWeight())
				.name(dto.getName())
				.image(dto.getImage())
				.build();

			return repository.save(medicine);
		} catch (Exception ex) {
			if (ex.getCause() instanceof ConstraintViolationException && ex.getMessage().contains(CONSTRAINT_NAME)) {
				throw new DuplicateException("Medical with that code already registered", dto.getCode());
			} else
				throw ex;
		}
	}

	@Override
	public List<Medicine> getMedicineList() {
		return repository.findAll();
	}
}
