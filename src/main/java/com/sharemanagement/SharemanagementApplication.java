package com.sharemanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class SharemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharemanagementApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
		
        return new ModelMapper();
    }
	
	@Bean
    public ObjectMapper objectMapper() {
		
        return new ObjectMapper();
    }

}
