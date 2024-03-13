package com.pcgiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pcgiang")
public class FlashCardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCardGameApplication.class, args);
	}

}
