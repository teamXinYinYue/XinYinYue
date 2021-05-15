/*
Navicat MySQL Data Transfer

Source Server         : docker
Source Server Version : 50562
Source Host           : 121.5.149.137:3306
Source Database       : xyy

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-05-15 14:45:12
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ca_id` int(11) NOT NULL AUTO_INCREMENT,
  `ca_name` varchar(60) DEFAULT NULL,
  `ca_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'rock', '摇滚自1xxx');
INSERT INTO `category` VALUES ('2', 'pop', '流行由');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `co_info` varchar(255) DEFAULT NULL,
  `co_date` date DEFAULT NULL,
  `u_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id` (`u_id`),
  KEY `m_id` (`m_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `music` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '0000-00-00', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('6', '1', '', '/XinYinYue_war/picture//20210514203358564929timg.jpg');
INSERT INTO `location` VALUES ('7', '1', '', '/XinYinYue_war/picture//20210514220508862902a08ba4d2e31dd0a1be0e04558fd4f70e.jpg');
INSERT INTO `location` VALUES ('8', '1', '', '/XinYinYue_war/picture//20210514222045085316a08ba4d2e31dd0a1be0e04558fd4f70e.jpg');
INSERT INTO `location` VALUES ('9', '1', '', '/XinYinYue_war/picture//20210514223416304786a08ba4d2e31dd0a1be0e04558fd4f70e.jpg');
INSERT INTO `location` VALUES ('10', '1', '', '/XinYinYue_war/picture//20210514223807811754timg.jpg');
INSERT INTO `location` VALUES ('11', '1', '', '/XinYinYue_war/picture//20210514223817991053timg.jpg');
INSERT INTO `location` VALUES ('12', '1', '', '/XinYinYue_war/picture//20210514223923767513a08ba4d2e31dd0a1be0e04558fd4f70e.jpg');
INSERT INTO `location` VALUES ('13', '1', '春光下的xxx', '/XinYinYue_war/picture//20210514224432524329timg.jpg');
INSERT INTO `location` VALUES ('14', '1', '春光下的xxx', '/XinYinYue_war/picture//20210514230846178118a08ba4d2e31dd0a1be0e04558fd4f70e.jpg');
INSERT INTO `location` VALUES ('15', '1', '春光下的xxx', '/XinYinYue_war/picture//20210514230908754938timg (1).jpg');
INSERT INTO `location` VALUES ('16', '1', '春光下的xxx', '/XinYinYue/picture//20210514152247774350a08ba4d2e31dd0a1be0e04558fd4f70e.jpg');
INSERT INTO `location` VALUES ('17', '1', '春光下的xxx', '/XinYinYue_war/picture//20210515144125183248timg.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', '1', '1', '1', '1', '25', '0000-00-00 00:00:00', null);
INSERT INTO `music` VALUES ('21', 'w', '1', '1', '1', '0', '2021-05-14 22:01:10', '/XinYinYue_war/music/rock/w');
INSERT INTO `music` VALUES ('22', '爱歌瘾歌', '1', '1', '1', '0', '2021-05-14 15:23:33', '/XinYinYue/music/rock/爱歌瘾歌');
INSERT INTO `music` VALUES ('23', 'saa啊啊啊', '1', '1', '1', '0', '2021-05-15 10:43:29', '/XinYinYue_war/music/rock/saa啊啊啊');
INSERT INTO `music` VALUES ('24', 'a阿萨', '1', '1', '1', '0', '2021-05-15 11:32:04', '/XinYinYue_war/music/rock/a阿萨');
INSERT INTO `music` VALUES ('25', '爱玩', '1', '1', '1', '0', '2021-05-15 11:43:26', '/XinYinYue_war/music/rock/爱玩');
INSERT INTO `music` VALUES ('26', '外围', '1', '1', '1', '0', '2021-05-15 11:44:00', '/XinYinYue_war/music/rock/外围');
INSERT INTO `music` VALUES ('27', '听筒', '1', '1', '1', '0', '2021-05-15 11:46:41', '/XinYinYue_war/music/rock/听筒');
INSERT INTO `music` VALUES ('28', '1啊呜', '1', '1', '1', '0', '2021-05-15 11:48:27', '/XinYinYue_war/music/rock/1啊呜');
INSERT INTO `music` VALUES ('29', '说', '1', '1', '1', '0', '2021-05-15 11:52:07', '/XinYinYue_war/music/rock/说');
INSERT INTO `music` VALUES ('30', '撒', '1', '1', '1', '0', '2021-05-15 11:56:19', '/XinYinYue_war/music/rock/撒');
INSERT INTO `music` VALUES ('31', 'asda', '1', '1', '1', '0', '2021-05-15 12:13:07', '/XinYinYue_war/music/rock/asda');
INSERT INTO `music` VALUES ('32', 'awdwad', '1', '1', '1', '0', '2021-05-15 12:15:12', '/XinYinYue_war/music/rock/awdwad');
INSERT INTO `music` VALUES ('33', 'awd', '1', '1', '1', '0', '2021-05-15 12:17:05', '/XinYinYue_war/music/rock/awd');
INSERT INTO `music` VALUES ('34', 'awd', '1', '1', '1', '2', '2021-05-15 12:18:29', '/XinYinYue_war/music/rock/awd');
INSERT INTO `music` VALUES ('35', '当方法', '1', '1', '1', '0', '2021-05-15 12:57:04', '/XinYinYue_war/music/rock/当方法');
INSERT INTO `music` VALUES ('36', 'ffdge', '1', '1', '1', '1', '2021-05-15 14:41:13', '/XinYinYue_war/music/rock/ffdge');

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
  CONSTRAINT `plmusic_ibfk_1` FOREIGN KEY (`p_name`) REFERENCES `playlist` (`p_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plmusic_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `playlist` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plmusic_ibfk_3` FOREIGN KEY (`m_id`) REFERENCES `music` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('1', '1', '1');

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
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1');
