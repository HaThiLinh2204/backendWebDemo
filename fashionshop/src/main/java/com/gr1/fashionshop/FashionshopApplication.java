package com.gr1.fashionshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
@EntityScan(basePackages = {"com.gr1.fashionshop.domain"})
@EnableCaching
@EnableJpaRepositories(basePackages = {
		"com.gr1.fashionshop.repository"
})
public class FashionshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionshopApplication.class, args);
	}

}
