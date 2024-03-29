DROP SCHEMA IF EXISTS `hibernate-one-to-many`;
CREATE SCHEMA `hibernate-one-to-many`;

USE `hibernate-one-to-many`;
SET FOREIGN_KEY_CHECKS=0;

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


DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          `title` varchar(128) DEFAULT NULL,
                          `instructor_id` int(11) DEFAULT NULL,

                          UNIQUE KEY `TITLE_UNIQUE` (`title`),

                          KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
                          CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`)
                              REFERENCES `instructor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
                          `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `course_id` int(11) DEFAULT NULL,
                          `rating` int(11) DEFAULT NULL,
                          `comment` varchar(45) DEFAULT NULL,
                          `created_at` datetime DEFAULT NULL,
                          `updated_at` datetime DEFAULT NULL,

                          KEY `FK_COURSE_idx` (`course_id`),
                          CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`)
                              REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
