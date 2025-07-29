package com.kaleshrikant.entry;

import com.kaleshrikant.event.VehicleEnteredEvent;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

public class EntryService {

	// save vehicle entry details to DB
	// allocate a parking slot
	// send notification to the user

	private final ParkingEntrryRepository parkingEntrryRepository;
	private final ApplicationEventPublisher publisher;

	public EntryService(ParkingEntrryRepository parkingEntrryRepository, ApplicationEventPublisher publisher) {
		this.parkingEntrryRepository = parkingEntrryRepository;
		this.publisher = publisher;
	}

	public void vehicleEntry(String vehicleNumber) {
		ParkingEntry parkingEntry = new ParkingEntry(null,vehicleNumber, LocalDateTime.now(), null, true);
		parkingEntrryRepository.save(parkingEntry);
		// publish an event
		publisher.publishEvent(new VehicleEnteredEvent(vehicleNumber, parkingEntry.getEntryTime()));
	}
}
