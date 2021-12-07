package com.wallet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/wallet/hello")
	public String home() {
		return ("<h1> Welcome Wallet</h1>");
	}
}
