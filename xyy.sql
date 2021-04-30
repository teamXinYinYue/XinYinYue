/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : xyy

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2021-04-21 22:03:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ca_id` int(11) NOT NULL,
  `ca_name` varchar(60) DEFAULT NULL,
  `ca_info` varchar(255) DEFAULT NULL,
  `l_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ca_id`),
  KEY `l_id` (`l_id`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`l_id`) REFERENCES `location` (`l_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `m_id` int(11) DEFAULT NULL,
  `co_info` varchar(255) DEFAULT NULL,
  `co_date` date DEFAULT NULL,
  `u_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id` (`u_id`),
  KEY `m_id` (`m_id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `music` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `l_id` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `music`
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `m_id` int(11) NOT NULL,
  `m_name` varchar(60) DEFAULT NULL,
  `ca_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `ca_id` (`ca_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `music_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `singer` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `music_ibfk_1` FOREIGN KEY (`ca_id`) REFERENCES `category` (`ca_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', '1', '1', '1', '1');

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
INSERT INTO `playlist` VALUES ('1', '1', '1');

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
  CONSTRAINT `plmusic_ibfk_3` FOREIGN KEY (`m_id`) REFERENCES `music` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plmusic_ibfk_1` FOREIGN KEY (`p_name`) REFERENCES `playlist` (`p_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plmusic_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `playlist` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plmusic
-- ----------------------------
INSERT INTO `plmusic` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int(11) NOT NULL,
  `roletype` varchar(30) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `singer`
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(30) DEFAULT NULL,
  `s_info` varchar(255) DEFAULT NULL,
  `image_name` varchar(60) DEFAULT NULL,
  `l_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `l_id` (`l_id`),
  CONSTRAINT `singer_ibfk_1` FOREIGN KEY (`l_id`) REFERENCES `location` (`l_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `r_id` int(11) DEFAULT NULL,
  `u_name` varchar(60) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `sign_info` varchar(100) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1');
