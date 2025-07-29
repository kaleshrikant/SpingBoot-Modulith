package com.kaleshrikant.entry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Shrikant Kale
 * @Date 7/25/25
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingEntry {
	@Id
	@GeneratedValue
	private Long id;
	private String vehicleNumber;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private boolean active;
}
