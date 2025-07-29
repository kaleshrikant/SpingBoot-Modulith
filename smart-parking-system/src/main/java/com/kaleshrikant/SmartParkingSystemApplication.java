package com.kaleshrikant;

import com.kaleshrikant.allocation.Slot;
import com.kaleshrikant.allocation.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartParkingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initSlots (SlotRepository slotRepository) {
		return args -> {
			if(slotRepository.count() == 0) {
				slotRepository.save(new Slot(null, "A1", true, null));
				slotRepository.save(new Slot(null, "A2", true, null));
				slotRepository.save(new Slot(null, "B1", true, null));
			}
		};
	}
}
