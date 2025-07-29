package com.kaleshrikant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SmartParkingSystemApplicationTests {

	@Test
	void contextLoads() {
		ApplicationModules module =  ApplicationModules
												.of(SmartParkingSystemApplication.class).verify();
		new Documenter((ApplicationModules) module).writeDocumentation();
	}

}
