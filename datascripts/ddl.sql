CREATE TABLE `ROLLINGSTONE_USER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  `SEX` varchar(1) NOT NULL,
  `MEMBER_TYPE` varchar(100) NOT NULL,
  `ACCOUNT_NUMBER` varchar(100) NOT NULL,
  `REGISTRATION_DATE` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(255) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `user_profile_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgnxjxbwinq6xla6qo0wi5o833` (`user_profile_id`),
  CONSTRAINT `FKgnxjxbwinq6xla6qo0wi5o833` FOREIGN KEY (`user_profile_id`) REFERENCES `rollingstone_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_address` varchar(255) NOT NULL,
  `zip_code` varchar(255) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjftwqebn4c1rknbhu0qjg5w21` (`account_id`),
  CONSTRAINT `FKjftwqebn4c1rknbhu0qjg5w21` FOREIGN KEY (`account_id`) REFERENCES `rollingstone_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
