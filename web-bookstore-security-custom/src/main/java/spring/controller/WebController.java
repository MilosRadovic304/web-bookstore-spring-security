package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@RequestMapping("/web")
public class WebController {

	//@RequestMapping("/index")
	@RequestMapping("/")
	public String showIndex(Model theModel) {
		
		return "index";
	}

	@RequestMapping("/ourfounder")
	public String showFounder(Model theModel) {
		
		return "ourfounder";
	}
	
	
	
	@RequestMapping("/contact")
	public String showContact(Model theModel) {
		
		return "contact";
	}
	
	
	@RequestMapping("/register")
	public String showRegister(Model theModel) {
		
		return "register";
	}
	
	@RequestMapping("/team")
	public String showTeam(Model theModel) {
		
		return "team";
	}
	
	

	
}
