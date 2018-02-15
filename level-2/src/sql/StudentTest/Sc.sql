DROP TABLE IF EXISTS Sc;

CREATE TABLE Sc(
  id INT NOT NULL AUTO_INCREMENT,
    student_id int NOT NULL,
    course_id int not null,
    score DOUBLE  not null,
    PRIMARY KEY ( id )
  )ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('1','1','90');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('1','2','80');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('1','3','81');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('1','4','82');

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('1','5','50');

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('2','1','70');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('2','2','71');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('2','3','72');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('2','4','73');

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('2','5','51');

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('3','1','74');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('3','2','71');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('3','3','75');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('3','4','76');

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('4','1','61');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('4','2','62');
INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('4','3','63');
-- INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('4','4','64');

INSERT INTO Sc (`student_id`,`course_id`,`score`) VALUES ('5','1','60');


