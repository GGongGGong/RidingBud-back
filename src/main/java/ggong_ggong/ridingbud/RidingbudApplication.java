package ggong_ggong.ridingbud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RidingbudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RidingbudApplication.class, args);
	}

}
