DROP SCHEMA IF EXISTS `hibernate-one-to-one`;
CREATE SCHEMA `hibernate-one-to-one`;
USE `hibernate-one-to-one`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     `youtube_channel` varchar(128) DEFAULT NULL,
                                     `hobby` varchar(45) DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
                              `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              `first_name` varchar(45) DEFAULT NULL,
                              `last_name` varchar(45) DEFAULT NULL,
                              `email` varchar(45) DEFAULT NULL,
                              `instructor_detail_id` int(11) DEFAULT NULL,

                              KEY `FK_DETAIL_idx` (`instructor_detail_id`),
                              CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
                                  REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;