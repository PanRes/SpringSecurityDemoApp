package gr.pr.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityDemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/overLords")
	public String overLords() {
		return "overLords";
	}
	
	@GetMapping("/castle")
	public String castle() {
		return "castle";
	}
	
	@GetMapping("/plebs")
	public String plebs() {
		return "plebs";
	}
}
