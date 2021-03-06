package app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Workers")
public class Worker {

	public enum Department { Greenkeepers, Accountants, Masseurs, Cleaners, Players };
	public enum StrongFoot { Left, Right, Both };
	public enum Position { Goalkeeper, Defender, Midfielder, Striker };
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int worker_id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Surname")
	private String surname;
	
	@Column(name="Earnings")
	private float earnings;
	
	@Column(name="Department")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Column(name="Is_player")
	private boolean isPlayer;
	
	@Column(name="Is_injured")
	private boolean isInjured;
	
	@Column(name="Shirt_number")
	private int shirtNumber;
	
	@Column(name="Strong_foot")
	@Enumerated(EnumType.STRING)
	private StrongFoot strongFoot;
	
	@Column(name="Height")
	private int height;
	
	@Column(name="Weight")
	private int weight;
	
	@Column(name="Position")
	@Enumerated(EnumType.STRING)
	private Position position;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="Club")
	private Club club;
	
	@OneToMany(mappedBy="initiator",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<Meeting> meetings;
	
	@OneToMany(mappedBy="worker",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<Invite> invites;

	
//	@Column(name="club")
//	private int club;
	
	public Worker() {
		
	}
	
	public Worker(String name, String surname, float earnings, String department, boolean isPlayer,
			boolean isInjured, int shirtNumber, String strongFoot, int height, int weight, String position) {
		
		this.name = name;
		this.surname = surname;
		this.earnings = earnings;
		this.department = Department.valueOf(department);
		this.isPlayer = isPlayer;
		this.isInjured = isInjured;
		this.shirtNumber = shirtNumber;
		this.strongFoot = StrongFoot.valueOf(strongFoot);
		this.height = height;
		this.weight = weight;
		this.position = Position.valueOf(position);
	}

	public Worker(String name, String surname, float earnings, String department) {
		
		this.name = name;
		this.surname = surname;
		this.earnings = earnings;
		this.department = Department.valueOf(department);
	}

	public int getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public float getEarnings() {
		return earnings;
	}

	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	public boolean isInjured() {
		return isInjured;
	}

	public void setInjured(boolean isInjured) {
		this.isInjured = isInjured;
	}

	public int getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	public StrongFoot getStrongFoot() {
		return strongFoot;
	}

	public void setStrongFoot(StrongFoot strongFoot) {
		this.strongFoot = strongFoot;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public List<Invite> getInvites() {
		return invites;
	}

	public void setInvites(List<Invite> invites) {
		this.invites = invites;
	}

	@Override
	public String toString() {
		return "Worker [worker_id=" + worker_id + ", name=" + name + ", surname=" + surname + ", earnings=" + earnings
				+ ", department=" + department + ", isPlayer=" + isPlayer + ", isInjured=" + isInjured
				+ ", shirtNumber=" + shirtNumber + ", strongFoot=" + strongFoot + ", height=" + height + ", weight="
				+ weight + ", position=" + position + ", club=" + club + "]";
	}
	
	public void addMeeting(Meeting tempMeeting) {
		if (meetings == null) {
			meetings = new ArrayList<>();
		}
		meetings.add(tempMeeting);
		tempMeeting.setInitiator(this);
	}
	
	public void addInvite(Invite tempInvite) {
		if (invites == null) {
			invites = new ArrayList<>();
		}
		invites.add(tempInvite);
		tempInvite.setWorker(this);
	}
	
	
}
