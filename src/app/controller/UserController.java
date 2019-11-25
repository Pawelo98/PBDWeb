package app.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.javafaker.Faker;

import app.entities.User;
import app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		List<User> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		return "list-users";
	}
	
	@PostMapping("/saveUsers")
	public String saveUsers(@RequestParam("value1") String str)
	{
		String[] roleList = new String[3];
		roleList[0] = "admin";
		roleList[1] = "administrative";
		roleList[2] = "physical";
		
		Random generator = new Random();
		Faker faker = new Faker();
		
		for(int i=0; i<40; i++)
		{
			String login = faker.name().username();
			String password = faker.code().asin();
			Date date = null;
			String name = faker.name().firstName();
			String surname = faker.name().lastName();
			String address = faker.address().fullAddress();
			
			User user = new User(login, password, date, name, surname, roleList[generator.nextInt(3)], address);
			
			userService.saveUser(user);
		}
		return "redirect:/user/list";
	}
}