package com.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/order/hello")
	public String home() {
		return ("<h1> Welcome Orders</h1>");
	}
}
