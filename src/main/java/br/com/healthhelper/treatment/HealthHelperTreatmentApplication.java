package br.com.healthhelper.treatment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HealthHelperTreatmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthHelperTreatmentApplication.class, args);
	}

}
