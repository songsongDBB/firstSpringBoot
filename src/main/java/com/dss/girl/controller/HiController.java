package com.dss.girl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@GetMapping(value = "/sayHi")
	public String sayHi() {
		return "hi";
	}
}
