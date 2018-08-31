package gr.pr.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/showMyLoginPage")
	public String showMyLoginPage() {
//		return "plainLogin";
		
		return "fancyLogin";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "/errorPages/403";
	}
}
