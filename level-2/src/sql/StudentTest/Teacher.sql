DROP TABLE IF EXISTS Teacher;

CREATE TABLE Teacher(
  id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY ( id )
  )ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO Teacher (`name`) VALUES ('霍金');
INSERT INTO Teacher (`name`) VALUES ('爱因斯坦');
INSERT INTO Teacher (`name`) VALUES ('牛顿');
INSERT INTO Teacher (`name`) VALUES ('马顿');

INSERT INTO Teacher (`name`) VALUES ('马三立');

INSERT INTO Teacher (`name`) VALUES ('孟德尔');