package com.yzeng.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-user")
@Component
public interface UserService {
	@GetMapping("/hi")
	String show(@RequestParam String name);
}
