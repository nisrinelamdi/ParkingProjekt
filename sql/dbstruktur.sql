create database DieGarage;

CREATE TABLE `etagen` (
  `etagen_id` int(11) NOT NULL AUTO_INCREMENT,
  `etagen_name` varchar(255) NOT NULL,
  PRIMARY KEY (`etagen_id`),
  UNIQUE KEY `etagen_name` (`etagen_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci AUTO_INCREMENT=12;



CREATE TABLE `parkplaetze` (
  `parkplatz_id` int(11) NOT NULL AUTO_INCREMENT,
  `parkplatz_name` varchar(255) NOT NULL,
  `etagen_id` int(11) DEFAULT NULL,
  `istBelegt` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`parkplatz_id`),
  KEY `etagen_id` (`etagen_id`),
  CONSTRAINT `parkplaetze_ibfk_1` FOREIGN KEY (`etagen_id`) REFERENCES `etagen` (`etagen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci AUTO_INCREMENT=28;



CREATE TABLE `parkdaten` (
  `parkdaten_id` int(11) NOT NULL AUTO_INCREMENT,
  `parkplatz_id` int(11) DEFAULT NULL,
  `besitzerVorname` varchar(255) DEFAULT NULL,
  `nachname` varchar(255) DEFAULT NULL,
  `fahrzeugtyp` varchar(255) DEFAULT NULL,
  `nummernschild` varchar(255) DEFAULT NULL,
  `parkzeitpunkt` datetime DEFAULT NULL,
  `ausfahrtszeitpunkt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`parkdaten_id`),
  UNIQUE KEY `nummernschild` (`nummernschild`),
  KEY `parkplatz_id` (`parkplatz_id`),
  CONSTRAINT `parkdaten_ibfk_1` FOREIGN KEY (`parkplatz_id`) REFERENCES `parkplaetze` (`parkplatz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci AUTO_INCREMENT=12;


CREATE TABLE `administratoren` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL,
  `kennwort` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci AUTO_INCREMENT=2;
