package com.kaleshrikant.entry;

import com.kaleshrikant.event.VehicleExitedEvent;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

public class ExitService {

	// save vehicle entry details to DB
	// allocate a parking slot
	// send notification to the user

	private final ParkingEntrryRepository parkingEntryRepository;
	private final ApplicationEventPublisher publisher;

	public ExitService(ParkingEntrryRepository parkingEntrryRepository, ApplicationEventPublisher publisher) {
		this.parkingEntryRepository = parkingEntrryRepository;
		this.publisher = publisher;
	}

	public void vehicleExit(String vehicleNumber) {
		// Find the vehicle entry form the DB
		ParkingEntry parkingEntry = parkingEntryRepository.findByVehicleNumberAndActiveTrue(vehicleNumber).orElseThrow(() -> new RuntimeException("No active entry found for vehicle " + vehicleNumber));
		// update exit time
		parkingEntry.setActive(false);
		parkingEntry.setEntryTime(LocalDateTime.now());
		// save to DB
		parkingEntryRepository.save(parkingEntry);
		// public vehicle exited event
		publisher.publishEvent(new VehicleExitedEvent(vehicleNumber, parkingEntry.getEntryTime(), parkingEntry.getEntryTime()));
	}
}
