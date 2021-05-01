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