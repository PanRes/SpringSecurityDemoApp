package gr.pr.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringSecurityDemoController {
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
}
