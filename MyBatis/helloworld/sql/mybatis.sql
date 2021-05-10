SET NAMES utf8mb4;
CREATE
DATABASE IF NOT EXISTS mybatisdb CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_cs_0900_as_cs';
CREATE
USER 'mybatisUser'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON mybatisdb.* TO
'mybatisUser'@'%' WITH GRANT OPTION ;
DROP TABLE IF EXISTS `mybatisdb`.`t_employee`;
CREATE TABLE `mybatisdb`.`t_employee`
(
    `id`      INT(11) PRIMARY KEY AUTO_INCREMENT,
    `empname` VARCHAR(50) NOT NULL,
    `gender`  INT(1),
    `email`   VARCHAR(100)
);

CREATE TABLE `mybatisdb`.`t_cat`
(
    `id`      INT(11) PRIMARY KEY AUTO_INCREMENT,
    `cName`   VARCHAR(100) NOT NULL,
    `cAge`    INT(2) NOT NULL,
    `cGender` INT(1) NOT NULL,
);

CREATE TABLE `mybatisdb`.`t_student`
(
    `id`      INT(11) PRIMARY KEY AUTO_INCREMENT,
    `stuName` VARCHAR(20)
);

CREATE TABLE `mybatisdb`.`t_teacher`
(
    `id`          INT(11)  PRIMARY KEY  AUTO_INCREMENT,
    `teacherName` VARCHAR(20),

);