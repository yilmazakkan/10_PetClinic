package com.yilmazakkan.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching   //casheden bilgileri getircek 2.kez girildiğinde rest controller findowners method düzeyinde yapıldı @Cacheable anatasyonu ile
@EnableJpaAuditing(auditorAwareRef = "petClinicAuditorAware")
@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(value=PetClinicProperties.class)
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);

	}

}
