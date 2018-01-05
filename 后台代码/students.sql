/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : students

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-01-05 11:37:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'chen', '男');
INSERT INTO `student` VALUES ('2', 'wang', '女');

-- ----------------------------
-- Table structure for `tb_good`
-- ----------------------------
DROP TABLE IF EXISTS `tb_good`;
CREATE TABLE `tb_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `num` int(11) NOT NULL,
  `proTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_good
-- ----------------------------
INSERT INTO `tb_good` VALUES ('1', '冰红茶', '40', '一月');
INSERT INTO `tb_good` VALUES ('2', '雪碧', '50', '二月');
INSERT INTO `tb_good` VALUES ('3', '可乐', '35', '三月');
INSERT INTO `tb_good` VALUES ('4', '茉莉花茶', '45', '四月');
INSERT INTO `tb_good` VALUES ('5', '冰绿茶', '60', '五月');
INSERT INTO `tb_good` VALUES ('6', '红牛', '55', '六月');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuNov` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '0104150418', '陈金华');
INSERT INTO `tb_user` VALUES ('2', '0104150419', '陈首批');
INSERT INTO `tb_user` VALUES ('3', '0104150420', '李思乐');
INSERT INTO `tb_user` VALUES ('4', '0104150421', '陈志斌');
INSERT INTO `tb_user` VALUES ('5', '0104150422', '陈志斌');
INSERT INTO `tb_user` VALUES ('6', '0104150418', '陈金华');
INSERT INTO `tb_user` VALUES ('7', '0104150419', '李思乐');
INSERT INTO `tb_user` VALUES ('8', '0104150420', '陈志斌');
INSERT INTO `tb_user` VALUES ('9', '0104150421', '陈志斌');
