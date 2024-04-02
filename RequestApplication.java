package com.example.Request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class RequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestApplication.class, args);
	}
	@Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return builder -> builder.modules(new JavaTimeModule());

}


}