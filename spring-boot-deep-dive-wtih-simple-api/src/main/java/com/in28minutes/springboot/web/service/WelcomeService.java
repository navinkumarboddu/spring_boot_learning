package com.in28minutes.springboot.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	@Value("${welcome.message}")
	private String welcomMessage;
	
	public String retrieveWelcomeMessage() {
		//Complex Method
		return welcomMessage;
	}
}