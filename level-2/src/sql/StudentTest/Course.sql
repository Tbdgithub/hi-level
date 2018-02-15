DROP TABLE IF EXISTS Course;

CREATE TABLE Course(
  id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    teacher_id int  not null,
    PRIMARY KEY ( id )
  )ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO Course (`name`,`teacher_id`) VALUES ('math','1');
INSERT INTO Course (`name`,`teacher_id`) VALUES ('physics','2');
INSERT INTO Course (`name`,`teacher_id`) VALUES ('english','3');
INSERT INTO Course (`name`,`teacher_id`) VALUES ('art','1');


INSERT INTO Course (`name`,`teacher_id`) VALUES ('ai','5');

-- INSERT INTO Course (`name`,`teacher_id`) VALUES ('chemistry','5');
