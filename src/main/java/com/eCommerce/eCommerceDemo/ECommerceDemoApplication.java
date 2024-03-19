package com.eCommerce.eCommerceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.eCommerce.eCommerceDemo")
public class ECommerceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceDemoApplication.class, args);
	}

}
