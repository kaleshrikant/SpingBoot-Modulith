package com.kaleshrikant.event;

import java.time.LocalDateTime;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

public record VehicleEnteredEvent(String vehicleNumber, LocalDateTime entryTime) {
}
