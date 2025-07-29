package com.kaleshrikant.allocation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shrikant Kale
 * @Date 7/25/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Slot {
	@Id
	@GeneratedValue
	private Long id;
	private String slotCode;
	private boolean available;
	private String vehicleNumber;
}
