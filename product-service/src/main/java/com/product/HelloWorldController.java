package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/product/hello")
	public String home() {
		return ("<h1> Welcome Product</h1>");
	}
}
