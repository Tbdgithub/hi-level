DROP TABLE IF EXISTS Student;

CREATE TABLE Student(
  id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age int  not null,
    sex VARCHAR(100) not NULL ,
    PRIMARY KEY ( id )
  )ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO Student (`name`,`age`,`sex`) VALUES ('tom','18','male');
INSERT INTO Student (`name`,`age`,`sex`) VALUES ('mike','19','male');
INSERT INTO Student (`name`,`age`,`sex`) VALUES ('tina','20','female');
INSERT INTO Student (`name`,`age`,`sex`) VALUES ('junia','17','female');
INSERT INTO Student (`name`,`age`,`sex`) VALUES ('jack','21','male');
