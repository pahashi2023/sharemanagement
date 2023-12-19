package com.sharemanagement.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class Hello {

	@GetMapping(value = "/indexs")
	public String getIndex() {
		return "Hello world";
	}
}
