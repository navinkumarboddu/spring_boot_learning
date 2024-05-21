package com.in28minutes.springboot.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.web.configuration.BasicConfiguration;
import com.in28minutes.springboot.web.service.WelcomeService;

@RestController
public class WelcomeController {

	// Auto wiring
	@Autowired
	private WelcomeService service;

	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}

	@Autowired
	private BasicConfiguration configuration;

	@RequestMapping("/dynamic-configuration")
	public Map dynamicConfiguration() {
		// Not the best practice to use a map to store differnt types!
		Map map = new HashMap();
		map.put("message", configuration.getMessage());
		map.put("number", configuration.getNumber());
		map.put("key", configuration.isValue());
		return map;
	}

}