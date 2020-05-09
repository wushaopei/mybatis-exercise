/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80016
Source Host           : localhost:3333
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-04-26 23:31:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '用户');
INSERT INTO `t_role` VALUES ('2', '管理员');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'jetty', '1');
INSERT INTO `t_user` VALUES ('2', 'kai', '1');
INSERT INTO `t_user` VALUES ('3', 'tom', '1');
INSERT INTO `t_user` VALUES ('4', 'lili', '1');
INSERT INTO `t_user` VALUES ('5', 'jete', '1');
INSERT INTO `t_user` VALUES ('6', 'kk', '0');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('1', '3');
INSERT INTO `t_user_role` VALUES ('1', '4');
INSERT INTO `t_user_role` VALUES ('2', '5');
INSERT INTO `t_user_role` VALUES ('2', '6');
