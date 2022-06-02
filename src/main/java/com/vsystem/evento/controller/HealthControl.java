package com.vsystem.evento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health")
public class HealthControl {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String find() {		
		return "comunicação ok";
	}

}
