package com.kaleshrikant.notification;

import com.kaleshrikant.event.VehicleEnteredEvent;
import com.kaleshrikant.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

@Service
public class NotificationService {

	@EventListener
	public void notifyOnVehicleEntry(VehicleEnteredEvent event) {
		// send notification to the user
		System.out.println("📧 Notification: Vehicle : "+event.vehicleNumber()+" entered at "+event.entryTime()+ ". Welcome ! 😍");
	}

	@EventListener
	public void notifyOnVehicleExit(VehicleExitedEvent event) {
		// send notification to the user
		System.out.println("📧 Notification: Vehicle : "+event.vehicleNumber()+" exited at "+event.entryTime()+ ". Bye ! 😍");
	}
}
