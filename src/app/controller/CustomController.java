package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomController {
	
	@RequestMapping("/list")
	public String listCustomers(Model model)
	{
		return "first-page";
	}
}
