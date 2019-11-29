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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Clubs")
public class Club {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int club_id;
	
	@Column(name="Name")
	private String name;
	
	public enum Nationality { Afghanistan, Albania, Algeria, AmericanSamoa ("American Samoa"), Andorra, Angola, Anguilla,
        Antarctica, AntiguaandBarbuda("Antigua and Barbuda"), Argentina, Armenia, Aruba, Australia, Austria, Azerbaijan, Bahamas,
        Bahrain, Bangladesh, Barbados, Belarus, Belgium, Belize, Benin, Bermuda, Bhutan, Bolivia,
        BosniaandHerzegowina("Bosnia and Herzegowina"), Botswana, BouvetIsland ("Bouvet Island"), Brazil, BritishIndianOceanTerritory ("British Indian Ocean Territory"), BruneiDarussalam ("Brunei Darussalam"),
        Bulgaria, BurkinaFaso ("Burkina Faso"), Burundi, Cambodia, Cameroon, Canada, CapeVerde ("Cape Verde"), CaymanIslands ("Cayman Islands"),
        CentralAfricanRepublic ("Central African Republic"), Chad, Chile, China, ChristmasIsland ("Christmas Island"),Cocos ("Cocos (Keeling) Islands"), Colombia,
        Comoros, Congo, CongoDR ("Congo, the Democratic Republic of the"), CookIslands ("Cook Islands"), CostaRica ("Costa Rica"),CotedIvore ("Cote d'Ivoire"),
        Croatia ("Croatia (Hrvatska)"), Cuba, Cyprus, CzechRepublic ("Czech Republic"), Denmark, Djibouti, Dominica, DominicanRepublic  ("Dominican Republic"),
        EastTimor ("East Timor"), Ecuador, Egypt, ElSalvador ("El Salvador"), EquatorialGuinea ("Equatorial Guinea"), Eritrea, Estonia, Ethiopia,
        FalklandIslands ("Falkland Islands (Malvinas)"), FaroeIslands ("Faroe Islands"), Fiji, Finland, France, FranceMetropolitan ("France Metropolitan"), FrenchGuiana ("French Guiana"),
        FrenchPolynesia ("French Polynesia"), FrenchSouthernTerritories ("French Southern Territories"), Gabon, Gambia, Georgia, Germany, Ghana, Gibraltar,
        Greece, Greenland, Grenada, Guadeloupe, Guam, Guatemala, Guinea, GuineaBissau ("Guinea-Bissau"), Guyana, Haiti,
        HeardandMcDonaldIslands ("Heard and Mc Donald Islands"), HolySee ("Holy See (Vatican City State)"), Honduras, HongKong ("Hong Kong"), Hungary, Iceland, India,
        Indonesia, Iran ("Iran (Islamic Republic of)"), Iraq, Ireland, Israel, Italy, Jamaica, Japan, Jordan,
        Kazakhstan, Kenya, Kiribati, Korea ("Korea Republic of"), KoreaDPR ("Democratic People's Republic of, Korea"), Kuwait,
        Kyrgyzstan, Lao ("Lao, People's Democratic Republic"), Latvia, Lebanon, Lesotho, Liberia, LibyanArabJamahiriya ("Libyan Arab Jamahiriya"),
        Liechtenstein, Lithuania, Luxembourg, Macau, Macedonia ("Macedonia, The Former Yugoslav Republic of"), Madagascar,
        Malawi, Malaysia, Maldives, Mali, Malta, MarshallIslands ("Marshall Islands"), Martinique, Mauritania, Mauritius,
        Mayotte, Mexico, Micronesia ("Micronesia, Federated States of"), Moldova ("Moldova, Republic of"), Monaco, Mongolia, Montserrat,
        Morocco, Mozambique, Myanmar, Namibia, Nauru, Nepal, Netherlands, NetherlandsAntilles ("Netherlands Antilles"),
        NewCaledonia ("New Caledonia"), NewZealand ("New Zealand"), Nicaragua, Niger, Nigeria, Niue, NorfolkIsland ("Norfolk Island"), NorthernMarianaIslands ("Northern Mariana Islands"),
        Norway, Oman, Pakistan, Palau, Panama, PapuaNewGuinea ("Papua New Guinea"), Paraguay, Peru, Philippines, Pitcairn,
        Poland, Portugal, PuertoRico ("Puerto Rico"), Qatar, Reunion, Romania, RussianFederation ("Russian Federation"), Rwanda,
        SaintKittsandNevis ("Saint Kitts and Nevis"), SaintLucia ("Saint Lucia"), SaintVincentandtheGrenadines ("Saint Vincent and the Grenadines"), Samoa, SanMarino ("San Marino"),
        SaoTomeandPrincipe ("Sao Tome and Principe"), SaudiArabia ("Saudi Arabia"), Senegal, Seychelles, SierraLeone ("Sierra Leone"), Singapore,
        Slovakia ("Slovakia (Slovak Republic)"), Slovenia, SolomonIslands ("Solomon Islands"), Somalia, SouthAfrica ("South Africa"),
        SouthGeorgiaandtheSouthSandwichIslands ("South Georgia and the South Sandwich Islands"), Spain, SriLanka ("Sri Lanka"), StHelena ("St. Helena"), StPierreandMiquelon ("St. Pierre and Miquelon"),
        Sudan, Suriname, SvalbardandJanMayenIslands ("Svalbard and Jan Mayen Islands"), Swaziland, Sweden, Switzerland, SyrianArabRepublic ("Syrian Arab Republic"),
        Taiwan, ProvinceofChina ("Province of China"), Tajikistan, Tanzania ("Tanzania, United Republic of"), Thailand, Togo, Tokelau, Tonga,
        TrinidadandTobago ("Trinidad and Tobago"), Tunisia, Türkiye, Turkmenistan, TurksandCaicosIslands ("Turks and Caicos Islands"), Tuvalu, Uganda, Ukraine,
        UnitedArabEmirates ("United Arab Emirates"), UnitedKingdom ("United Kingdom"), UnitedStates ("United States"), UnitedStatesMinorOutlyingIslands ("United States Minor Outlying Islands"), Uruguay,
        Uzbekistan, Vanuatu, Venezuela, Vietnam, VirginIslandsBr ("Virgin Islands (British)"), VirginIslandsUS ("Virgin Islands (U.S.)"),
        WallisandFutunaIslands ("Wallis and Futuna Islands"), WesternSahara ("Western Sahara"), Yemen, Yugoslavia, Zambia, Zimbabwe;
        
		private String name;
		
		Nationality() {
	    }
	
	    Nationality(String name) {
	        this.name = name;
	    }
	
	    public String getName() {
	        return this.name;
	    }    
    };
    
    @Column(name="Nationality")
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
    
    @Column(name="Shirt_home")
	private String shirtHome;
    
    @Column(name="Shirt_away")
	private String shirtAway;
    
    @OneToMany(mappedBy="host",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<Match> hostMatches;
    
	/*
	 * @OneToMany(mappedBy="visitor", cascade= {CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) private
	 * List<Match> visitorMatches;
	 */
    
    @OneToMany(mappedBy="club",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<Worker> workers;

    @OneToMany(mappedBy="club",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<User> users;
    
    @OneToMany(mappedBy="club",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<Building> buildings;
    
    public Club() {
    	
    }
    
	public Club(String name, String nationality, String shirtHome, String shirtAway) {  //dopisac nationality
		
		this.name = name;
		this.nationality = Nationality.valueOf(nationality);
		this.shirtHome = shirtHome;
		this.shirtAway = shirtAway;
	}



	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShirtHome() {
		return shirtHome;
	}

	public void setShirtHome(String shirtHome) {
		this.shirtHome = shirtHome;
	}

	public String getShirtAway() {
		return shirtAway;
	}

	public void setShirtAway(String shirtAway) {
		this.shirtAway = shirtAway;
	}
	
	

	public List<Match> getHostMatches() {
		return hostMatches;
	}

	public void setHostMatches(List<Match> hostMatches) {
		this.hostMatches = hostMatches;
	}

	/*
	 * public List<Match> getVisitorMatches() { return visitorMatches; }
	 * 
	 * public void setVisitorMatches(List<Match> visitorMatches) {
	 * this.visitorMatches = visitorMatches; }
	 */
	
	

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	
    
	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	@Override
	public String toString() {
		return "Club [club_id=" + club_id + ", name=" + name + ", shirtHome=" + shirtHome + ", shirtAway=" + shirtAway
				+ ", hostMatches=" + hostMatches +
				//", visitorMatches=" + visitorMatches +
				", workers=" + workers + "]";
	}

	public void addHost(Match tempMatch) {
		if (hostMatches == null) {
			hostMatches = new ArrayList<>();
		}
		hostMatches.add(tempMatch);
		tempMatch.setHost(this);
	}
	
	/*
	 * public void addVisitor(Match tempMatch) { if (visitorMatches == null) {
	 * visitorMatches = new ArrayList<>(); } visitorMatches.add(tempMatch);
	 * tempMatch.setVisitor(this); }
	 */
	
	public void addWorker(Worker tempWorker) {
		if (workers == null) {
			workers = new ArrayList<>();
		}
		workers.add(tempWorker);
		tempWorker.setClub(this);
	}
	
	
	public void addUser(User tempUser) {
		if (users == null) {
			users = new ArrayList<>();
		}
		users.add(tempUser);
		tempUser.setClub(this);
	}
	
	public void addBuilding(Building tempBuilding) {
		if (buildings == null) {
			buildings = new ArrayList<>();
		}
		buildings.add(tempBuilding);
		tempBuilding.setClub(this);
	}
	
	
    
}
