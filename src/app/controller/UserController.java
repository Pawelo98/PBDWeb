package app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
import app.service.MatchService;


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
	
	@Autowired
	private MatchService matchService;
	
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
		//dodawanie danych do bazy - obecnie skrypt
		/*
		Random generator = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<Referee> referees = new ArrayList<Referee>();
		// dodawanie sêdziów
		for(int i=0; i<40; i++)
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
			referees.add(ref);
		}
		
		// dodawanie klubów
		ArrayList<Club> clubs = new ArrayList<Club>();
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
			clubs.add(club);
			
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
				
				Date from = format.parse("2019-01-01");
				Date to = format.parse("2022-12-31");
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
			int win_pts = 3;
			int draw_pts = 1;
			
			League league = new League(name, nationality, level, win_pts, draw_pts);
			leagueService.saveLeague(league);
			
			// generuj terminarz
			if(nationality.equals("Poland")) {
				ArrayList<Club> league_clubs = new ArrayList<Club>();
				String national = "br";
				for(int l=0; l<clubs.size(); l++) {
					national = clubs.get(l).getNationality().toString();
					if(national.equals("Poland")) {
						league_clubs.add(clubs.get(l));
					}
				}
				
				Club[] tab = league_clubs.toArray(new Club[0]);
									
				Date from = format.parse("2017-07-31");
				Date to = format.parse("2018-05-31");
				Date from2 = format.parse("2018-07-31");
				Date to2 = format.parse("2019-05-31");
				Faker faker = new Faker();
				
				// ka¿da iteracja to jedna kolejka ligi
				for(int j=0; j<30; j++) {
					Date game_date = new Date();
					if(year==2018) {
						game_date = faker.date().between(from, to);
					}
					else {
						game_date = faker.date().between(from2, to2);
					}
					
					if(j%2==0) {
						if(game_date.before(new Date())) {
							
							int home_goals = generator.nextInt(4);
							int away_goals = generator.nextInt(4);
							String winner;
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match = new Match(home_goals, away_goals, game_date, winner);
							match.setHost(tab[0]);
							match.setVisitor(tab[1]);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							
							//2 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match2 = new Match(home_goals, away_goals, game_date, winner);
							match2.setHost(tab[15]);
							match2.setVisitor(tab[2]);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							
							//3 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match3 = new Match(home_goals, away_goals, game_date, winner);
							match3.setHost(tab[14]);
							match3.setVisitor(tab[3]);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							
							//4 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match4 = new Match(home_goals, away_goals, game_date, winner);
							match4.setHost(tab[13]);
							match4.setVisitor(tab[4]);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							
							//5 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match5 = new Match(home_goals, away_goals, game_date, winner);
							match5.setHost(tab[12]);
							match5.setVisitor(tab[5]);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							
							//6 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match6 = new Match(home_goals, away_goals, game_date, winner);
							match6.setHost(tab[11]);
							match6.setVisitor(tab[6]);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							
							//7 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match7 = new Match(home_goals, away_goals, game_date, winner);
							match7.setHost(tab[10]);
							match7.setVisitor(tab[7]);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							
							//8 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match8 = new Match(home_goals, away_goals, game_date, winner);
							match8.setHost(tab[9]);
							match8.setVisitor(tab[8]);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
						} else {
							//1 mecz
							Match match = new Match(game_date);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							//2 mecz
							Match match2 = new Match(game_date);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							//3 mecz
							Match match3 = new Match(game_date);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							//4 mecz
							Match match4 = new Match(game_date);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							//5 mecz
							Match match5 = new Match(game_date);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							//6 mecz
							Match match6 = new Match(game_date);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							//7 mecz
							Match match7 = new Match(game_date);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							//8 mecz
							Match match8 = new Match(game_date);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
						}
						
					} else {
						
						if(game_date.before(new Date())) {
							
							int home_goals = generator.nextInt(4);
							int away_goals = generator.nextInt(4);
							String winner;
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match = new Match(home_goals, away_goals, game_date, winner);
							match.setHost(tab[1]);
							match.setVisitor(tab[0]);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							
							//2 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match2 = new Match(home_goals, away_goals, game_date, winner);
							match2.setHost(tab[2]);
							match2.setVisitor(tab[15]);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							
							//3 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match3 = new Match(home_goals, away_goals, game_date, winner);
							match3.setHost(tab[3]);
							match3.setVisitor(tab[14]);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							
							//4 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match4 = new Match(home_goals, away_goals, game_date, winner);
							match4.setHost(tab[4]);
							match4.setVisitor(tab[13]);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							
							//5 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match5 = new Match(home_goals, away_goals, game_date, winner);
							match5.setHost(tab[5]);
							match5.setVisitor(tab[12]);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							
							//6 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match6 = new Match(home_goals, away_goals, game_date, winner);
							match6.setHost(tab[6]);
							match6.setVisitor(tab[11]);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							
							//7 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match7 = new Match(home_goals, away_goals, game_date, winner);
							match7.setHost(tab[7]);
							match7.setVisitor(tab[10]);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							
							//8 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match8 = new Match(home_goals, away_goals, game_date, winner);
							match8.setHost(tab[8]);
							match8.setVisitor(tab[9]);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
						} else {
							//1 mecz
							Match match = new Match(game_date);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							//2 mecz
							Match match2 = new Match(game_date);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							//3 mecz
							Match match3 = new Match(game_date);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							//4 mecz
							Match match4 = new Match(game_date);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							//5 mecz
							Match match5 = new Match(game_date);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							//6 mecz
							Match match6 = new Match(game_date);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							//7 mecz
							Match match7 = new Match(game_date);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							//8 mecz
							Match match8 = new Match(game_date);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
						}
						
					}
				}
			} else {
				ArrayList<Club> league_clubs = new ArrayList<Club>();
				String national = "trrrr";
				for(int l=0; l<clubs.size(); l++) {
					national = clubs.get(l).getNationality().toString();
					if(national.equals("Germany")) {
						league_clubs.add(clubs.get(l));
					}
				}
				
				Club[] tab = league_clubs.toArray(new Club[0]);
									
				Date from = format.parse("2017-07-31");
				Date to = format.parse("2018-05-31");
				Date from2 = format.parse("2018-07-31");
				Date to2 = format.parse("2019-05-31");
				Faker faker = new Faker();
				
				// ka¿da iteracja to jedna kolejka ligi
				for(int j=0; j<30; j++) {
					Date game_date = new Date();
					if(year==2018) {
						game_date = faker.date().between(from, to);
					}
					else {
						game_date = faker.date().between(from2, to2);
					}
					
					if(j%2==0) {
						if(game_date.before(new Date())) {
							
							int home_goals = generator.nextInt(4);
							int away_goals = generator.nextInt(4);
							String winner;
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match = new Match(home_goals, away_goals, game_date, winner);
							match.setHost(tab[0]);
							match.setVisitor(tab[1]);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							
							//2 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match2 = new Match(home_goals, away_goals, game_date, winner);
							match2.setHost(tab[17]);
							match2.setVisitor(tab[2]);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							
							//3 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match3 = new Match(home_goals, away_goals, game_date, winner);
							match3.setHost(tab[16]);
							match3.setVisitor(tab[3]);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							
							//4 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match4 = new Match(home_goals, away_goals, game_date, winner);
							match4.setHost(tab[15]);
							match4.setVisitor(tab[4]);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							
							//5 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match5 = new Match(home_goals, away_goals, game_date, winner);
							match5.setHost(tab[14]);
							match5.setVisitor(tab[5]);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							
							//6 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match6 = new Match(home_goals, away_goals, game_date, winner);
							match6.setHost(tab[13]);
							match6.setVisitor(tab[6]);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							
							//7 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match7 = new Match(home_goals, away_goals, game_date, winner);
							match7.setHost(tab[12]);
							match7.setVisitor(tab[7]);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							
							//8 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match8 = new Match(home_goals, away_goals, game_date, winner);
							match8.setHost(tab[11]);
							match8.setVisitor(tab[8]);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
							
							//9 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match9 = new Match(home_goals, away_goals, game_date, winner);
							match9.setHost(tab[10]);
							match9.setVisitor(tab[9]);
							int ref9 = generator.nextInt(referees.size()-2);
							match9.addReferee(referees.get(ref9));
							match9.addReferee(referees.get(ref9+1));
							match9.addReferee(referees.get(ref9+2));
							match9.setLeague(league);
							matchService.saveMatch(match9);
						} else {
							//1 mecz
							Match match = new Match(game_date);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							//2 mecz
							Match match2 = new Match(game_date);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							//3 mecz
							Match match3 = new Match(game_date);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							//4 mecz
							Match match4 = new Match(game_date);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							//5 mecz
							Match match5 = new Match(game_date);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							//6 mecz
							Match match6 = new Match(game_date);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							//7 mecz
							Match match7 = new Match(game_date);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							//8 mecz
							Match match8 = new Match(game_date);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
							//9 mecz
							Match match9 = new Match(game_date);
							int ref9 = generator.nextInt(referees.size()-2);
							match9.addReferee(referees.get(ref9));
							match9.addReferee(referees.get(ref9+1));
							match9.addReferee(referees.get(ref9+2));
							match9.setLeague(league);
							matchService.saveMatch(match9);
						}
						
					} else {
						
						if(game_date.before(new Date())) {
							
							int home_goals = generator.nextInt(4);
							int away_goals = generator.nextInt(4);
							String winner;
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match = new Match(home_goals, away_goals, game_date, winner);
							match.setHost(tab[1]);
							match.setVisitor(tab[0]);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							
							//2 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match2 = new Match(home_goals, away_goals, game_date, winner);
							match2.setHost(tab[2]);
							match2.setVisitor(tab[17]);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							
							//3 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match3 = new Match(home_goals, away_goals, game_date, winner);
							match3.setHost(tab[3]);
							match3.setVisitor(tab[16]);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							
							//4 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match4 = new Match(home_goals, away_goals, game_date, winner);
							match4.setHost(tab[4]);
							match4.setVisitor(tab[15]);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							
							//5 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match5 = new Match(home_goals, away_goals, game_date, winner);
							match5.setHost(tab[5]);
							match5.setVisitor(tab[14]);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							
							//6 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match6 = new Match(home_goals, away_goals, game_date, winner);
							match6.setHost(tab[6]);
							match6.setVisitor(tab[13]);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							
							//7 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match7 = new Match(home_goals, away_goals, game_date, winner);
							match7.setHost(tab[7]);
							match7.setVisitor(tab[12]);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							
							//8 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match8 = new Match(home_goals, away_goals, game_date, winner);
							match8.setHost(tab[8]);
							match8.setVisitor(tab[11]);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
							
							//9 mecz
							home_goals = generator.nextInt(4);
							away_goals = generator.nextInt(4);
							
							if (home_goals>away_goals) {
								winner = "One";
							}
							else if(home_goals==away_goals) {
								winner = "Zero";
							}
							else {
								winner = "Two";
							}
							Match match9 = new Match(home_goals, away_goals, game_date, winner);
							match9.setHost(tab[9]);
							match9.setVisitor(tab[10]);
							int ref9 = generator.nextInt(referees.size()-2);
							match9.addReferee(referees.get(ref9));
							match9.addReferee(referees.get(ref9+1));
							match9.addReferee(referees.get(ref9+2));
							match9.setLeague(league);
							matchService.saveMatch(match9);
						} else {
							//1 mecz
							Match match = new Match(game_date);
							int ref = generator.nextInt(referees.size()-2);
							match.addReferee(referees.get(ref));
							match.addReferee(referees.get(ref+1));
							match.addReferee(referees.get(ref+2));
							match.setLeague(league);
							matchService.saveMatch(match);
							//2 mecz
							Match match2 = new Match(game_date);
							int ref2 = generator.nextInt(referees.size()-2);
							match2.addReferee(referees.get(ref2));
							match2.addReferee(referees.get(ref2+1));
							match2.addReferee(referees.get(ref2+2));
							match2.setLeague(league);
							matchService.saveMatch(match2);
							//3 mecz
							Match match3 = new Match(game_date);
							int ref3 = generator.nextInt(referees.size()-2);
							match3.addReferee(referees.get(ref3));
							match3.addReferee(referees.get(ref3+1));
							match3.addReferee(referees.get(ref3+2));
							match3.setLeague(league);
							matchService.saveMatch(match3);
							//4 mecz
							Match match4 = new Match(game_date);
							int ref4 = generator.nextInt(referees.size()-2);
							match4.addReferee(referees.get(ref4));
							match4.addReferee(referees.get(ref4+1));
							match4.addReferee(referees.get(ref4+2));
							match4.setLeague(league);
							matchService.saveMatch(match4);
							//5 mecz
							Match match5 = new Match(game_date);
							int ref5 = generator.nextInt(referees.size()-2);
							match5.addReferee(referees.get(ref5));
							match5.addReferee(referees.get(ref5+1));
							match5.addReferee(referees.get(ref5+2));
							match5.setLeague(league);
							matchService.saveMatch(match5);
							//6 mecz
							Match match6 = new Match(game_date);
							int ref6 = generator.nextInt(referees.size()-2);
							match6.addReferee(referees.get(ref6));
							match6.addReferee(referees.get(ref6+1));
							match6.addReferee(referees.get(ref6+2));
							match6.setLeague(league);
							matchService.saveMatch(match6);
							//7 mecz
							Match match7 = new Match(game_date);
							int ref7 = generator.nextInt(referees.size()-2);
							match7.addReferee(referees.get(ref7));
							match7.addReferee(referees.get(ref7+1));
							match7.addReferee(referees.get(ref7+2));
							match7.setLeague(league);
							matchService.saveMatch(match7);
							//8 mecz
							Match match8 = new Match(game_date);
							int ref8 = generator.nextInt(referees.size()-2);
							match8.addReferee(referees.get(ref8));
							match8.addReferee(referees.get(ref8+1));
							match8.addReferee(referees.get(ref8+2));
							match8.setLeague(league);
							matchService.saveMatch(match8);
							//9 mecz
							Match match9 = new Match(game_date);
							int ref9 = generator.nextInt(referees.size()-2);
							match9.addReferee(referees.get(ref9));
							match9.addReferee(referees.get(ref9+1));
							match9.addReferee(referees.get(ref9+2));
							match9.setLeague(league);
							matchService.saveMatch(match9);
						}
						
					}
					
					// zamiana indeksów w tablicy
					if(nationality.equals("Poland")) {
						Club temp = tab[1];
						tab[1] = tab[15];
						for(int g=15; g>2; g--)
							tab[g] = tab[g-1];
						tab[2] = temp;
					} else {
						Club temp = tab[1];
						tab[1] = tab[17];
						for(int g=17; g>2; g--)
							tab[g] = tab[g-1];
						tab[2] = temp;
					}
				}
			}
		}
		*/
		return "redirect:/user/list";
	}
}