package com.kaleshrikant.allocation;

import com.kaleshrikant.event.VehicleEnteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Consumer Class created for Events
 * @author Shrikant Kale
 * @Date 7/29/25
 */

@Service
public class SlotAllocationService {

	private final SlotRepository slotRepository;

	public SlotAllocationService(SlotRepository slotRepository) {
		this.slotRepository = slotRepository;
	}

	@EventListener // now this method will act as a consumer
	public void handleVehicleEntry(VehicleEnteredEvent event) {
		// find the available slot to allocate
		Slot slot = slotRepository
				.findFirstByAvailableTrue()
				.orElseThrow(() -> new RuntimeException(" No available slots !"));
			slot.setAvailable(false);
			slot.setVehicleNumber(event.vehicleNumber());

		// then update the slot DB
			slotRepository.save(slot);
		System.out.println("Allocated Slot : "+slot.getSlotCode() + "to Vehicle : "+slot.getVehicleNumber());

	}
}
