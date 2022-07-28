DROP DATABASE IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `username` varchar(50) NOT NULL,
                         `password` varchar(68) NOT NULL,
                         `enabled` tinyint(1) NOT NULL,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES
    ('user','{bcrypt}$2a$10$LPLwgoRzzv431IyDnAE9RuWuTRb4lhmvN.rwx09kE1m/WihnLrb5e',1),
    ('employee','{bcrypt}$2a$10$KiY3QMoLPQ45BaWhb0wcyuFQIGgORhjD7qjHyRt8ZuAXSmAoo4zh.',1),
    ('admin','{bcrypt}$2a$10$qNokV2V4AFyGPysn/Y/J7uZMXglIEDBkfLAD8QKoTqyUFfNCIGb2y',1),
    ('manager','{bcrypt}$2a$10$ju69EQYbmxN7uX9xzE6itOVL8QJMPwMDSq/KXWhMMKQYiJKJjogUy',1);


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
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
    ('user','ROLE_USER'),
    ('employee','ROLE_USER'),
    ('employee','ROLE_EMPLOYEE'),
    ('manager','ROLE_USER'),
    ('manager','ROLE_EMPLOYEE'),
    ('manager','ROLE_MANAGER'),
    ('admin','ROLE_USER'),
    ('admin','ROLE_EMPLOYEE'),
    ('admin','ROLE_MANAGER'),
    ('admin','ROLE_ADMIN');
