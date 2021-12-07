package com.website;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/ecommerce/hello")
	public String home() {
		return ("<h1> Welcome Website Controller</h1>");
	}
}
