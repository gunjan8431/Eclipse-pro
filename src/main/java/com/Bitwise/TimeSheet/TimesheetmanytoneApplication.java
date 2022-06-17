package com.Bitwise.TimeSheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class TimesheetmanytoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetmanytoneApplication.class, args);
	}

}
