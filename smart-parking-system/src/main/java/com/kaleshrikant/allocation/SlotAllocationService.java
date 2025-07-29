package com.kaleshrikant.allocation;

import com.kaleshrikant.event.VehicleEnteredEvent;
import com.kaleshrikant.event.VehicleExitedEvent;
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

	@EventListener // now this method will act as a consumer
	public void handleVehicleExit(VehicleExitedEvent event) {
			slotRepository
				// find the alloted slot to DB
				.findByVehicleNumber(event.vehicleNumber())
				.ifPresentOrElse(slot -> {
					// free the slot
					slot.setAvailable(true);
					// set the exited vehicle number
					slot.setVehicleNumber(null);
					// then update the slot DB
					slotRepository.save(slot);
					System.out.println("Freed Slot : "+slot.getSlotCode() + "from Vehicle : "+slot.getVehicleNumber());
				}, () -> {
					throw  new RuntimeException(" No available vehicle for this slots !"+ event.vehicleNumber());
				});
	}
}
