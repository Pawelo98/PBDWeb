package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clubs")
public class Club {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
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
        TrinidadandTobago ("Trinidad and Tobago"), Tunisia, T�rkiye, Turkmenistan, TurksandCaicosIslands ("Turks and Caicos Islands"), Tuvalu, Uganda, Ukraine,
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
    
    @Column(name="Shirt_home")
	private String shirtHome;
    
    @Column(name="Shirt_away")
	private String shirtAway;

    public Club() {
    	
    }
    
	public Club(int id, String name, String shirtHome, String shirtAway) {  //dopisac nationality
		
		this.id = id;
		this.name = name;
		this.shirtHome = shirtHome;
		this.shirtAway = shirtAway;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", shirtHome=" + shirtHome + ", shirtAway=" + shirtAway + "]";
	}
    
    
}
