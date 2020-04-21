package com.occamsrazor.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootConfiguration
@Controller
public class HomeController {
	@GetMapping("/")
	public String hello() {
		return "index.html";
	}
}
