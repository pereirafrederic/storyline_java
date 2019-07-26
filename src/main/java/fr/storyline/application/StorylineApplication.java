package fr.storyline.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class StorylineApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StorylineApplication.class, args);
	}
	

}
