package com.cart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/cart/hello")
	public String home() {
		return ("<h1> Welcome Cart</h1>");
	}
}
