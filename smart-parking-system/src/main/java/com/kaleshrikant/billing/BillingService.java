package com.kaleshrikant.billing;

import com.kaleshrikant.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

@Service
public class BillingService {

	private final BillingRecordRepository billingRecordRepository;

	public BillingService(BillingRecordRepository billingRecordRepository) {
		this.billingRecordRepository = billingRecordRepository;
	}

	@EventListener
	public void handleVehicleExit(VehicleExitedEvent event) {
		// calculate billing amount based on duration
		Duration duration = Duration.between(event.entryTime(), event.exitTime());
		double billingAmount = Math.max(20, (duration.toMinutes() / 60.0) * 50);// 💵 50/hour
		// save to DB
		BillingRecord billingRecord = new BillingRecord(null, event.vehicleNumber(),billingAmount, event.exitTime());
		billingRecordRepository.save(billingRecord);
		System.out.println("✅ Billed ₹" + billingAmount + " for vehicle " + event.vehicleNumber() +
				" from " + event.entryTime() + " to " + event.exitTime());
	}
}
