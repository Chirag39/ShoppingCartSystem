package com.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/user/hello")
	public String home() {
		return ("<h1> Welcome User</h1>");
	}
}
