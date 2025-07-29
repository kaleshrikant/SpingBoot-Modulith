package com.kaleshrikant.allocation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Shrikant Kale
 * @Date 7/25/25
 */

public interface SlotRepository extends JpaRepository<Slot, Long> {
	Optional<Slot> findFirstByAvailableTrue();
}
