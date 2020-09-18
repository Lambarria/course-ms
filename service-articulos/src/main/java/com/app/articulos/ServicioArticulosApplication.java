package com.app.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioArticulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioArticulosApplication.class, args);
	}

}
