package app.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.javafaker.Faker;

import app.entities.Club;
import app.entities.League;
import app.entities.Match;
import app.entities.Referee;
import app.entities.User;
import app.service.ClubService;
import app.service.RefereeService;
import app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RefereeService refereeService;
	
	@Autowired
	private ClubService clubService;
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		List<League> users = userService.getLeagues();
		
		model.addAttribute("users", users);
		
		return "list-users";
	}
	
	@PostMapping("/list")
	public String saveUsers()
	{
		Random generator = new Random();
		
		// dodawanie sêdziów
//		for(int i=0; i<20; i++)
//		{
//			String[] countryCodes = Locale.getISOCountries();
//			Locale gb = new Locale("en-GB");
//			Locale locale = new Locale("", countryCodes[generator.nextInt(countryCodes.length)]);
//			
//			String nationality = locale.getDisplayCountry(gb);
//			Faker faker = new Faker(locale);
//			String name = faker.name().firstName();
//			String surname = faker.name().lastName();
//			
//			Referee ref = new Referee(name, surname, nationality);
//			refereeService.saveReferee(ref);
//		}
		
		// dodawanie klubów
		for(int i=0; i<34; i++)
		{
			Faker fakerZwykly = new Faker();
			Locale gb = new Locale("de-DE");
			Locale pl = new Locale("pl-PL");
			
			Faker faker;
			String nationality;
			if(i<18) {
				faker = new Faker(gb);
				nationality = "Germany";
			} else {
				faker = new Faker(pl);
				nationality = "Poland";
			}
				
			String name = faker.team().name();
			String shirtHome = faker.color().name();
			String shirtAway = faker.color().name();
			
			Club club = new Club(name, nationality, shirtHome, shirtAway);
			clubService.saveClub(club);
			
			// dodawanie u¿ytkowników
			if(i==0)
			{
				for(int j=0; j<3; j++) {
					String login = "";
					String password = "";
					String role = "";
					if(j==0)
					{
						login = "admin";
						password = "admin";
						role = "admin";
					} else if(j==1) {
						login = "administrative";
						password = "administrative";
						role = "administrative";
					} else if(j==2) {
						login = "physical";
						password = "physical";
						role = "physical";
					}
					
					Date registration = new Date();
					String name2 = faker.name().firstName();
					String surname = faker.name().lastName();
					String address = faker.address().fullAddress();
					
					User user = new User(login, password, registration, name2, surname, role, address);
					user.setClub(club);
					userService.saveUser(user);
				}
			}
		}
		return "redirect:/user/list";
	}
}