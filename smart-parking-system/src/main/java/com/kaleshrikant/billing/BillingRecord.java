package com.kaleshrikant.billing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillingRecord {
	@Id
	@GeneratedValue
	private Long id;
	private String vehicleNumber;
	private double amount;
	private LocalDateTime billingTime;
}
