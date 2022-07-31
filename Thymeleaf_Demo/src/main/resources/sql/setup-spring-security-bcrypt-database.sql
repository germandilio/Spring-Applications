DROP DATABASE  IF EXISTS `spring_security_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `spring_security_bcrypt`;
USE `spring_security_bcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL PRIMARY KEY,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES
#        login - password
#        user - user
#        employee - employee
#        manager - manager
('user','{bcrypt}$2a$10$V5JpQC63uMYceGqHq43TNOHdV.Oz37v2cMgef.bhhJvJw1B4SFLGa',1),
('employee','{bcrypt}$2a$10$GcsLKH6sM6ieNTAwfmNEXuyu5fzs0f3bxExOoxqybmt.DW0Ujk2zi',1),
('manager','{bcrypt}$2a$10$KRHx8DXuibiuxqqtqTry7.mZfehDBh2s1yTK9rVHVUqI1kaBOC4MO',1),
('admin','{bcrypt}$2a$10$RrIakV3bYhWCJyj6HOfYh.O5mWFA6T/ciNg5/cckKihaaOPdQdUNa',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('user','ROLE_USER'),
('employee','ROLE_EMPLOYEE'),
('manager','ROLE_MANAGER'),
('manager','ROLE_EMPLOYEE'),
('manager','ROLE_USER'),
('admin','ROLE_ADMIN'),
('admin','ROLE_MANAGER'),
('admin','ROLE_EMPLOYEE'),
('admin','ROLE_USER');


