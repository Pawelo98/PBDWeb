package app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import app.entities.Invite;
import app.entities.League;
import app.entities.Match;
import app.entities.Meeting;
import app.entities.Referee;
import app.entities.User;
import app.entities.Worker;
import app.entities.Building;
import app.entities.Building.Type;
import app.entities.Worker.Position;
import app.entities.Worker.StrongFoot;
import app.service.BuildingService;
import app.service.ClubService;
import app.service.RefereeService;
import app.service.UserService;
import app.service.WorkerService;
import app.service.LeagueService;
import app.service.MeetingService;
import app.service.InviteService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RefereeService refereeService;
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private WorkerService workerService;
	
	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private InviteService inviteService;
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		List<League> users = userService.getLeagues();
		
		model.addAttribute("users", users);
		
		return "list-users";
	}
	
	@PostMapping("/list")
	public String saveUsers() throws ParseException
	{
		Random generator = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		// dodawanie sêdziów
		for(int i=0; i<20; i++)
		{
			String[] countryCodes = Locale.getISOCountries();
			Locale gb = new Locale("en-GB");
			Locale locale = new Locale("", countryCodes[generator.nextInt(countryCodes.length)]);
			
			String nationality = locale.getDisplayCountry(gb);
			Faker faker = new Faker(locale);
			String name = faker.name().firstName();
			String surname = faker.name().lastName();
			
			Referee ref = new Referee(name, surname, nationality);
			refereeService.saveReferee(ref);
		}
		
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
			
			// dodawanie pracowników
			ArrayList<Worker> workers = new ArrayList<Worker>();
			for(int g=0; g<30; g++) {
				String nameWorker = faker.name().firstName();
				String surnameWorker = faker.name().lastName();
				float earnings = 2000 + generator.nextInt(4000);
				String[] roles = {"Greenkeepers", "Accountants", "Masseurs", "Cleaners", "Players"};
				String[] positions = {"Goalkeeper", "Defender", "Midfielder", "Striker"};
				String role = roles[generator.nextInt(roles.length)];
				
				if(g<23)
				{
					boolean isPlayer = true;
					boolean isInjured = false;
					int shirtNumber = generator.nextInt(23) + 1;
					String strongFoot = "Right";
					int height = 170 + generator.nextInt(30);
					int weight = 170 + generator.nextInt(30);
					String position = positions[generator.nextInt(positions.length)];
					Worker worker = new Worker(nameWorker, surnameWorker, earnings, role,  isPlayer,
							isInjured, shirtNumber, strongFoot, height, weight, position);
					worker.setClub(club);
					workerService.saveWorker(worker);
					workers.add(worker);
				} else {
					Worker worker = new Worker(nameWorker, surnameWorker, earnings, role);
					worker.setClub(club);
					workerService.saveWorker(worker);
					workers.add(worker);
				}
			}
			
			// dodawanie budynków klubowych
			ArrayList<Building> buildings = new ArrayList<Building>();
			for(int h=0; h<5; h++) {
				String nameBuilding = faker.company().name();
				String addressBuilding = faker.address().fullAddress();
				float surface = 200 + generator.nextInt(2000);
				String[] types = {"Pitch", "Training", "Medical", "Research", "Warehouse"};
				String type = types[generator.nextInt(types.length)];
				if(h==0)
					type = "Stadium";
				Building building = new Building(surface, nameBuilding, addressBuilding, type);
				building.setClub(club);
				buildingService.saveBuilding(building);
				buildings.add(building);
			}
			
			// dodawanie spotkañ
			ArrayList<Meeting> meetings = new ArrayList<Meeting>();
			for (int k=0; k<3; k++) {
				Building building = buildings.get(generator.nextInt(buildings.size()));
				String room = String.valueOf(generator.nextInt(900) + 100);
				Worker initiator = workers.get(generator.nextInt(workers.size()));
				float estimated_length = generator.nextFloat() + generator.nextInt(5);
				
				Date from = format.parse("2019-01-01 01:00");
				Date to = format.parse("2022-12-31 23:00");
				Date meeting_date = faker.date().between(from, to);   //dodaæ czas, czy moze isc pare zaproszen do jednego?
				
				Meeting meeting = new Meeting(room, estimated_length, meeting_date);
				meeting.setInitiator(initiator);
				meeting.setBuilding(building);
				meetingService.saveMeeting(meeting);
				meetings.add(meeting);
				
				//dodawanie zaproszeñ
				for (int l=0; l<5; l++) {
					String message = "Zapraszam na spotkanie które odbêdzie siê w budynku: " + meeting.getBuilding().getName() + " w pokoju: " + meeting.getRoom()
									+ " w terminie: " + meeting.getMeeting_date();
					
					Worker worker = workers.get(generator.nextInt(workers.size()));
					
					Invite invite = new Invite(message);
					invite.setMeeting(meeting);
					invite.setWorker(worker);
					inviteService.saveInvite(invite);
					
				}				
			}			
		}
		
		// dodawanie lig
		for (int i=0; i<4; i++) {
			
			String nationality;
			String name;
			int year = 2019;
			if(i<2) {
				nationality = "Germany";
				name = nationality + " " + (year-i);
			} else {
				nationality = "Poland";
				name = nationality + " " + (year-i+2);
			}
			int level = 1;
			int win_pts = generator.nextInt(2) + 2;
			int draw_pts = 1;
			
			League league = new League(name, nationality, level, win_pts, draw_pts);
			leagueService.saveLeague(league);
		}
		return "redirect:/user/list";
	}
}