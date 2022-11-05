package com.wellsfargo.SoftBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.wellsfargo.SoftBank"})
@EntityScan("com.wellsfargo.SoftBank")
@EnableJpaRepositories("com.wellsfargo.SoftBank")
public class SoftBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftBankApplication.class, args);
	}
 
}
