package app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
@Table(name="Leagues")
public class League {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int league_id;
	
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
	    
	    public static Nationality enumFromString(String displayString)
	    {
	        for(Nationality type : Nationality.values()) {
	            if(type.toString().equals(displayString))
	                return type;
	        }
	        
	        Random generator = new Random();
	        Nationality nat = Nationality.values()[generator.nextInt(Nationality.values().length)];
	        return nat;
	    }
    };
    
    @Column(name="Nationality")
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
    
    @Column(name="Level")
	private int level;
    
    @Column(name="Win_pts")
	private int win_pts;
    
    @Column(name="Draw_pts")
	private int draw_pts;
    
    @OneToMany(mappedBy="league",
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
    private List<Match> matches;

    public League() {
    	
    }
    
	public League(String name, String nationality, int level, int win_pts, int draw_pts) {
		
		this.name = name;
		this.nationality = Nationality.enumFromString(nationality);
		this.level = level;
		this.win_pts = win_pts;
		this.draw_pts = draw_pts;
	}

	

	public int getLeague_id() {
		return league_id;
	}

	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getWin_pts() {
		return win_pts;
	}

	public void setWin_pts(int win_pts) {
		this.win_pts = win_pts;
	}

	public int getDraw_pts() {
		return draw_pts;
	}

	public void setDraw_pts(int draw_pts) {
		this.draw_pts = draw_pts;
	}
	
	

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	
    
	@Override
	public String toString() {
		return "League [league_id=" + league_id + ", name=" + name + ", level=" + level + ", win_pts=" + win_pts
				+ ", draw_pts=" + draw_pts + ", matches=" + matches + "]";
	}

	public void add(Match tempMatch) {
		if (matches == null) {
			matches = new ArrayList<>();
		}
		matches.add(tempMatch);
		tempMatch.setLeague(this);
	}
    
}
