package com.gd.trackshows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TrackShowsApplication {
	public String testFn() {
		return "Test";
	}

	@RequestMapping("/")
	public String home() {
		String testStr = testFn();
		System.out.println(testStr);
		return "Hello World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(TrackShowsApplication.class, args);
	}

}
