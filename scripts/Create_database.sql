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
  `Nationality` ENUM("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
            "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
            "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
            "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
            "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
            "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
            "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
            "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
            "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
            "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
            "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
            "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
            "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
            "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
            "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
            "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
            "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
            "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
            "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
            "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
            "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
            "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
            "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
            "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
            "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
            "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
            "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe") NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Clubs` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Name` varchar(128) DEFAULT NULL,
  `Nationality` ENUM("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
            "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
            "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
            "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
            "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
            "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
            "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
            "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
            "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
            "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
            "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
            "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
            "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
            "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
            "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
            "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
            "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
            "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
            "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
            "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
            "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
            "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
            "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
            "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
            "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
            "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
            "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe") NOT NULL,
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
  `Type` ENUM('Stadium', 'Pitch') DEFAULT NULL,
  `Club` INT NOT NULL,
  FOREIGN KEY(`Club`) REFERENCES `Clubs`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Leagues` (
  `Id` INT NOT NULL AUTO_INCREMENT UNIQUE,
  `Name` varchar(128) NOT NULL UNIQUE,
  `Nationality` ENUM("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
            "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
            "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
            "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
            "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
            "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
            "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
            "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
            "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
            "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
            "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
            "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
            "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
            "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
            "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
            "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
            "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
            "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
            "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
            "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
            "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
            "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
            "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
            "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
            "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
            "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
            "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe") DEFAULT NULL,
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
  `Message` varchar(128) DEFAULT NULL,
  `Meeting` INT NOT NULL,
  `Worker` INT NOT NULL,
  FOREIGN KEY(`Worker`) REFERENCES `Workers`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY(`Meeting`) REFERENCES `Meetings`(`Id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY(`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
