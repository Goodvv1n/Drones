package ru.goodvvin.drones.data.medicine;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for operations with medicine db entities
 */
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
