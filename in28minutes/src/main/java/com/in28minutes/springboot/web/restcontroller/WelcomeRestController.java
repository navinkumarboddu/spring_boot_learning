package com.in28minutes.springboot.web.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "This is great !!!";
	}
}
