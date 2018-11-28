package com.yzeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	private Logger LOG = LoggerFactory.getLogger(IndexController.class); 
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hi")
	public String show(@RequestParam String name) {
		return name+ ":" + port;
	}
}
