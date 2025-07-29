package com.kaleshrikant.entry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Shrikant Kale
 * @Date 7/25/25
 */

public interface ParkingEntrryRepository extends JpaRepository<ParkingEntry, Long> {

	Optional <ParkingEntry> findByVehicleNumberAndActiveTrue(String vehicleNumber);
}
