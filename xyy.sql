/*
Navicat MySQL Data Transfer

Source Server         : docker
Source Server Version : 50562
Source Host           : 121.5.149.137:3306
Source Database       : xyy

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-05-27 22:20:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_uname` varchar(60) DEFAULT NULL,
  `admin_pass_word` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ca_id` int(11) NOT NULL AUTO_INCREMENT,
  `ca_name` varchar(60) DEFAULT NULL,
  `ca_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'rock', '摇滚xxx');
INSERT INTO `category` VALUES ('2', 'pop', '流行由');
INSERT INTO `category` VALUES ('3', 'electronic', '电子音乐xxx');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `co_info` varchar(255) DEFAULT NULL,
  `co_date` datetime DEFAULT NULL,
  `u_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id` (`u_id`),
  KEY `m_id` (`m_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `music` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '48', 'd', null, '1');
INSERT INTO `comment` VALUES ('8', '48', 'dawdwadwa', '2021-05-27 21:25:49', '1');
INSERT INTO `comment` VALUES ('9', '48', '3333wa', '2021-05-27 21:26:11', '1');

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) NOT NULL,
  `i_info` varchar(60) DEFAULT NULL,
  `i_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `location_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `singer` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('30', '1', '春光下dwadwa的xxx', '/picture/2021052709opop2547480089timg (2).jpg');

-- ----------------------------
-- Table structure for `music`
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(60) DEFAULT NULL,
  `ca_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `hot` int(11) DEFAULT NULL,
  `mdate` datetime DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `ca_id` (`ca_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `music_ibfk_1` FOREIGN KEY (`ca_id`) REFERENCES `category` (`ca_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `music_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `singer` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('48', '1', '1', '1', '1', '1', '2021-05-27 09:36:09', '/music/rock/1');
INSERT INTO `music` VALUES ('50', '232', '3', '1', '1', '1', '2021-05-27 20:16:54', null);
INSERT INTO `music` VALUES ('51', '2aaa32', '2', '1', '1', '1', '2021-05-27 20:17:37', null);
INSERT INTO `music` VALUES ('52', 'a32', '2', '1', '1', '1', '2021-05-27 21:02:18', null);

-- ----------------------------
-- Table structure for `playlist`
-- ----------------------------
DROP TABLE IF EXISTS `playlist`;
CREATE TABLE `playlist` (
  `p_name` varchar(60) NOT NULL,
  `u_id` int(11) NOT NULL,
  `p_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_name`,`u_id`),
  KEY `u_id` (`u_id`),
  KEY `p_name` (`p_name`),
  CONSTRAINT `playlist_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playlist
-- ----------------------------
INSERT INTO `playlist` VALUES ('2asd', '1', 'a2222');

-- ----------------------------
-- Table structure for `plmusic`
-- ----------------------------
DROP TABLE IF EXISTS `plmusic`;
CREATE TABLE `plmusic` (
  `m_id` int(11) NOT NULL DEFAULT '0',
  `u_id` int(11) NOT NULL DEFAULT '0',
  `p_name` varchar(60) NOT NULL DEFAULT '',
  PRIMARY KEY (`m_id`,`u_id`,`p_name`),
  KEY `p_name` (`p_name`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `plmusic_ibfk_1` FOREIGN KEY (`p_name`) REFERENCES `playlist` (`p_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plmusic_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `playlist` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plmusic_ibfk_3` FOREIGN KEY (`m_id`) REFERENCES `music` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plmusic
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `roletype` varchar(30) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `singer`
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(30) DEFAULT NULL,
  `s_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('1', '1', '1');
INSERT INTO `singer` VALUES ('4', '林sss俊杰', '《ss江南》');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) DEFAULT NULL,
  `u_name` varchar(60) DEFAULT NULL,
  `pass_word` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `sign_info` varchar(100) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '1', 'awsl', 'AWsl123', '0', '', '');
INSERT INTO `user` VALUES ('3', '1', 'hhh', 'Ii1234', '0', null, null);
INSERT INTO `user` VALUES ('4', '1', 'shage', 'Ii1234', '0', null, null);
INSERT INTO `user` VALUES ('35', '1', 'ssdwa', 'Saw56465', '0', null, null);
