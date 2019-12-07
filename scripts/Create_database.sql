DROP SCHEMA IF EXISTS `Club_management`;
CREATE SCHEMA `Club_management`;
use `Club_management`;

DROP TABLE IF EXISTS `Referees`;
DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Matches`;
DROP TABLE IF EXISTS `Workers`;
DROP TABLE IF EXISTS `Clubs`;
DROP TABLE IF EXISTS `Leagues`;
DROP TABLE IF EXISTS `Refereeing`;
DROP TABLE IF EXISTS `Buildings`;
DROP TABLE IF EXISTS `Meetings`;

CREATE TABLE IF NOT EXISTS `Referees` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Name` varchar(128) DEFAULT NULL,
  `Surname` varchar(128) DEFAULT NULL,
  `Nationality` ENUM ("Afghanistan", "Albania", "Algeria", "AmericanSamoa", "Andorra", "Angola", "Anguilla",
        "Antarctica", "AntiguaandBarbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
        "BosniaandHerzegowina", "Botswana", "BouvetIsland", "Brazil", "BritishIndianOceanTerritory", "BruneiDarussalam",
        "Bulgaria", "BurkinaFaso", "Burundi", "Cambodia", "Cameroon", "Canada", "CapeVerde", "CaymanIslands",
        "CentralAfricanRepublic" , "Chad", "Chile", "China", "ChristmasIsland" , "Cocos" , "Colombia",
        "Comoros", "Congo", "CongoDR" , "CookIslands", "CostaRica", "CotedIvore",
        "Croatia", "Cuba", "Cyprus", "CzechRepublic", "Denmark", "Djibouti", "Dominica", "DominicanRepublic",
        "EastTimor", "Ecuador", "Egypt", "ElSalvador", "EquatorialGuinea", "Eritrea", "Estonia", "Ethiopia",
        "FalklandIslands", "FaroeIslands", "Fiji", "Finland", "France", "FranceMetropolitan", "FrenchGuiana",
        "FrenchPolynesia", "FrenchSouthernTerritories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
        "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "GuineaBissau", "Guyana", "Haiti",
        "HeardandMcDonaldIslands", "HolySee", "Honduras", "HongKong", "Hungary", "Iceland", "India",
        "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
        "Kazakhstan", "Kenya", "Kiribati", "Korea", "KoreaDPR", "Kuwait",
        "Kyrgyzstan", "Lao", "Latvia", "Lebanon", "Lesotho", "Liberia", "LibyanArabJamahiriya",
        "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar",
        "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "MarshallIslands", "Martinique", "Mauritania", "Mauritius",
        "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat",
        "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "NetherlandsAntilles",
        "NewCaledonia", "NewZealand", "Nicaragua", "Niger", "Nigeria", "Niue", "NorfolkIsland", "NorthernMarianaIslands",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "PapuaNewGuinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
        "Poland", "Portugal", "PuertoRico", "Qatar", "Reunion", "Romania", "RussianFederation", "Rwanda",
        "SaintKittsandNevis", "SaintLucia", "SaintVincentandtheGrenadines", "Samoa", "SanMarino",
        "SaoTomeandPrincipe", "SaudiArabia", "Senegal", "Seychelles", "SierraLeone", "Singapore",
        "Slovakia", "Slovenia", "SolomonIslands", "Somalia", "SouthAfrica",
        "SouthGeorgiaandtheSouthSandwichIslands", "Spain", "SriLanka", "StHelena", "StPierreandMiquelon",
        "Sudan", "Suriname", "SvalbardandJanMayenIslands", "Swaziland", "Sweden", "Switzerland", "SyrianArabRepublic",
        "Taiwan", "ProvinceofChina", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga",
        "TrinidadandTobago", "Tunisia", "Türkiye", "Turkmenistan", "TurksandCaicosIslands", "Tuvalu", "Uganda", "Ukraine",
        "UnitedArabEmirates", "UnitedKingdom", "UnitedStates", "UnitedStatesMinorOutlyingIslands", "Uruguay",
        "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "VirginIslandsBr", "VirginIslandsUS",
        "WallisandFutunaIslands", "WesternSahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe") NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Clubs` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Name` varchar(128) DEFAULT NULL,
  `Nationality` ENUM ("Afghanistan", "Albania", "Algeria", "AmericanSamoa", "Andorra", "Angola", "Anguilla",
        "Antarctica", "AntiguaandBarbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
        "BosniaandHerzegowina", "Botswana", "BouvetIsland", "Brazil", "BritishIndianOceanTerritory", "BruneiDarussalam",
        "Bulgaria", "BurkinaFaso", "Burundi", "Cambodia", "Cameroon", "Canada", "CapeVerde", "CaymanIslands",
        "CentralAfricanRepublic" , "Chad", "Chile", "China", "ChristmasIsland" , "Cocos" , "Colombia",
        "Comoros", "Congo", "CongoDR" , "CookIslands", "CostaRica", "CotedIvore",
        "Croatia", "Cuba", "Cyprus", "CzechRepublic", "Denmark", "Djibouti", "Dominica", "DominicanRepublic",
        "EastTimor", "Ecuador", "Egypt", "ElSalvador", "EquatorialGuinea", "Eritrea", "Estonia", "Ethiopia",
        "FalklandIslands", "FaroeIslands", "Fiji", "Finland", "France", "FranceMetropolitan", "FrenchGuiana",
        "FrenchPolynesia", "FrenchSouthernTerritories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
        "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "GuineaBissau", "Guyana", "Haiti",
        "HeardandMcDonaldIslands", "HolySee", "Honduras", "HongKong", "Hungary", "Iceland", "India",
        "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
        "Kazakhstan", "Kenya", "Kiribati", "Korea", "KoreaDPR", "Kuwait",
        "Kyrgyzstan", "Lao", "Latvia", "Lebanon", "Lesotho", "Liberia", "LibyanArabJamahiriya",
        "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar",
        "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "MarshallIslands", "Martinique", "Mauritania", "Mauritius",
        "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat",
        "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "NetherlandsAntilles",
        "NewCaledonia", "NewZealand", "Nicaragua", "Niger", "Nigeria", "Niue", "NorfolkIsland", "NorthernMarianaIslands",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "PapuaNewGuinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
        "Poland", "Portugal", "PuertoRico", "Qatar", "Reunion", "Romania", "RussianFederation", "Rwanda",
        "SaintKittsandNevis", "SaintLucia", "SaintVincentandtheGrenadines", "Samoa", "SanMarino",
        "SaoTomeandPrincipe", "SaudiArabia", "Senegal", "Seychelles", "SierraLeone", "Singapore",
        "Slovakia", "Slovenia", "SolomonIslands", "Somalia", "SouthAfrica",
        "SouthGeorgiaandtheSouthSandwichIslands", "Spain", "SriLanka", "StHelena", "StPierreandMiquelon",
        "Sudan", "Suriname", "SvalbardandJanMayenIslands", "Swaziland", "Sweden", "Switzerland", "SyrianArabRepublic",
        "Taiwan", "ProvinceofChina", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga",
        "TrinidadandTobago", "Tunisia", "Türkiye", "Turkmenistan", "TurksandCaicosIslands", "Tuvalu", "Uganda", "Ukraine",
        "UnitedArabEmirates", "UnitedKingdom", "UnitedStates", "UnitedStatesMinorOutlyingIslands", "Uruguay",
        "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "VirginIslandsBr", "VirginIslandsUS",
        "WallisandFutunaIslands", "WesternSahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe") NOT NULL,
  `Shirt_home` varchar(128) DEFAULT NULL,
  `Shirt_away` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Users` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Login` varchar(128) NOT NULL UNIQUE,
  `Password` varchar(128) NOT NULL,
  `Registration_date` DATE NOT NULL,
  `Name` varchar(128) DEFAULT NULL,
  `Surname` varchar(128) DEFAULT NULL,
  `Role` ENUM('admin', 'administrative', 'physical') NOT NULL,
  `Address` varchar(128) DEFAULT NULL,
  `Club` INT NOT NULL,
  FOREIGN KEY(`Club`) REFERENCES `Clubs`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Workers` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Name` varchar(128) DEFAULT NULL,
  `Surname` varchar(128) DEFAULT NULL,
  `Earnings` DECIMAL(50, 2) DEFAULT NULL,
  `Department` ENUM('Greenkeepers', 'Accountants', 'Masseurs', 'Cleaners', 'Players') DEFAULT NULL,
  `Is_player` BOOL DEFAULT FALSE,
  `Is_injured` BOOL DEFAULT FALSE,
  `Shirt_number` INT DEFAULT NULL,
  `Strong_foot` ENUM('Left', 'Right', 'Both') DEFAULT NULL,
  `Height` INT DEFAULT NULL,
  `Weight` INT DEFAULT NULL,
  `Position` ENUM('Goalkeeper', 'Defender', 'Midfielder', 'Striker') DEFAULT NULL,
  `Club` INT DEFAULT NULL,
  FOREIGN KEY(`Club`) REFERENCES `Clubs`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Buildings` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Surface` DECIMAL(50, 2) DEFAULT NULL,
  `Name` varchar(128) DEFAULT NULL,
  `Address` varchar(128) DEFAULT NULL,
  `Type` ENUM('Stadium', 'Pitch', 'Training', 'Medical', 'Research', 'Warehouse') DEFAULT NULL,
  `Club` INT NOT NULL,
  FOREIGN KEY(`Club`) REFERENCES `Clubs`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Leagues` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Name` varchar(128) NOT NULL UNIQUE,
  `Nationality` ENUM ("Afghanistan", "Albania", "Algeria", "AmericanSamoa", "Andorra", "Angola", "Anguilla",
        "Antarctica", "AntiguaandBarbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
        "BosniaandHerzegowina", "Botswana", "BouvetIsland", "Brazil", "BritishIndianOceanTerritory", "BruneiDarussalam",
        "Bulgaria", "BurkinaFaso", "Burundi", "Cambodia", "Cameroon", "Canada", "CapeVerde", "CaymanIslands",
        "CentralAfricanRepublic" , "Chad", "Chile", "China", "ChristmasIsland" , "Cocos" , "Colombia",
        "Comoros", "Congo", "CongoDR" , "CookIslands", "CostaRica", "CotedIvore",
        "Croatia", "Cuba", "Cyprus", "CzechRepublic", "Denmark", "Djibouti", "Dominica", "DominicanRepublic",
        "EastTimor", "Ecuador", "Egypt", "ElSalvador", "EquatorialGuinea", "Eritrea", "Estonia", "Ethiopia",
        "FalklandIslands", "FaroeIslands", "Fiji", "Finland", "France", "FranceMetropolitan", "FrenchGuiana",
        "FrenchPolynesia", "FrenchSouthernTerritories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
        "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "GuineaBissau", "Guyana", "Haiti",
        "HeardandMcDonaldIslands", "HolySee", "Honduras", "HongKong", "Hungary", "Iceland", "India",
        "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
        "Kazakhstan", "Kenya", "Kiribati", "Korea", "KoreaDPR", "Kuwait",
        "Kyrgyzstan", "Lao", "Latvia", "Lebanon", "Lesotho", "Liberia", "LibyanArabJamahiriya",
        "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar",
        "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "MarshallIslands", "Martinique", "Mauritania", "Mauritius",
        "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat",
        "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "NetherlandsAntilles",
        "NewCaledonia", "NewZealand", "Nicaragua", "Niger", "Nigeria", "Niue", "NorfolkIsland", "NorthernMarianaIslands",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "PapuaNewGuinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
        "Poland", "Portugal", "PuertoRico", "Qatar", "Reunion", "Romania", "RussianFederation", "Rwanda",
        "SaintKittsandNevis", "SaintLucia", "SaintVincentandtheGrenadines", "Samoa", "SanMarino",
        "SaoTomeandPrincipe", "SaudiArabia", "Senegal", "Seychelles", "SierraLeone", "Singapore",
        "Slovakia", "Slovenia", "SolomonIslands", "Somalia", "SouthAfrica",
        "SouthGeorgiaandtheSouthSandwichIslands", "Spain", "SriLanka", "StHelena", "StPierreandMiquelon",
        "Sudan", "Suriname", "SvalbardandJanMayenIslands", "Swaziland", "Sweden", "Switzerland", "SyrianArabRepublic",
        "Taiwan", "ProvinceofChina", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga",
        "TrinidadandTobago", "Tunisia", "Türkiye", "Turkmenistan", "TurksandCaicosIslands", "Tuvalu", "Uganda", "Ukraine",
        "UnitedArabEmirates", "UnitedKingdom", "UnitedStates", "UnitedStatesMinorOutlyingIslands", "Uruguay",
        "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "VirginIslandsBr", "VirginIslandsUS",
        "WallisandFutunaIslands", "WesternSahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe") DEFAULT NULL,
  `Level` INT NOT NULL,
  `Win_pts` INT NOT NULL,
  `Draw_pts` INT NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Matches` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Host` INT NOT NULL,
  `Visitor` INT NOT NULL,
  `Home_goals` INT DEFAULT NULL,
  `Away_goals` INT DEFAULT NULL,
  `Game_date` DATE NOT NULL,
  `Winner` ENUM('1', '0', '2') DEFAULT NULL,
  `League` INT DEFAULT NULL,
  FOREIGN KEY(`Host`) REFERENCES `Clubs`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY(`Visitor`) REFERENCES `Clubs`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY(`League`) REFERENCES `Leagues`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CHECK(NOT(`Host` = `Visitor`)),
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Refereeing` (
  `Match` INT NOT NULL,
  `Referee` INT NOT NULL,
  FOREIGN KEY(`Match`) REFERENCES `Matches`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY(`Referee`) REFERENCES `Referees`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY(`Match`, `Referee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- kto, gdzie, kto organizuje
CREATE TABLE IF NOT EXISTS `Meetings` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Building` INT DEFAULT NULL,
  `Room` varchar(128) DEFAULT NULL,
  `Initiator` INT NOT NULL,
  `Estimated_length` DECIMAL(50, 2) DEFAULT NULL,
  `Meeting_date` DATE NOT NULL,
  FOREIGN KEY(`Initiator`) REFERENCES `Workers`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY(`Building`) REFERENCES `Buildings`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY(`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Invites` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Message` varchar(256) DEFAULT NULL,
  `Meeting` INT NOT NULL,
  `Worker` INT NOT NULL,
  FOREIGN KEY(`Worker`) REFERENCES `Workers`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY(`Meeting`) REFERENCES `Meetings`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY(`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
