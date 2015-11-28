create database webarch;

use webarch;

CREATE TABLE t_user (
	id INT auto_increment PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	PASSWORD VARCHAR(40) NOT NULL,
	sex INT NOT NULL,
	WORK VARCHAR(40) NOT NULL
) ENGINE = INNODB;

create user 'webarch'@'localhost' IDENTIFIED by 'webarch';
grant all PRIVILEGES on webarch.* to 'webarch'@'localhost';