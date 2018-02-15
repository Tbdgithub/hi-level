--1. 1、	查询“math”课程比“english”课程成绩高的所有学生的学号；

SELECT a.name FROM Student a WHERE a.id IN
(
SELECT  a.student_id FROM

 (SELECT a.student_id ,a.score FROM Sc a ,Course b WHERE a.course_id=b.id and  b.name='math' )a
,
(SELECT a.student_id,a.score FROM Sc a ,Course b WHERE a.course_id=b.id AND  b.name='english')b

WHERE a.student_id=b.student_id

and  a.score> b.score
)

或者 ：
SELECT  a.student_id FROM

 (SELECT a.student_id ,a.score FROM Sc a  WHERE a.course_id=1 )a
,
(SELECT a.student_id,a.score FROM Sc a  WHERE a.course_id=3 )b

WHERE a.student_id=b.student_id

AND  a.score> b.score

2.查询平均成绩大于80的同学的学号和平均成绩

select  a.student_id ,avg(a.score)  from Sc a, Student b where a.student_id=b.id
group by a.student_id
having avg(a.score)>80

或者 ：
SELECT  a.student_id ,AVG(a.score)  FROM Sc a, Student b WHERE a.student_id=b.id
GROUP BY b.id
HAVING AVG(a.score)>80

3.	查询所有同学的学号、姓名、选课数、总成绩；
select a.id ,a.name ,count(a.id),sum(b.score)
from Student a,Score b
where a.id=b.student_id
group by a.id

4.查询姓“马”的老师的个数
SELECT COUNT( DISTINCT(`name`)) FROM Teacher  a WHERE a.name LIKE '马%'

5. 查询没学过“牛顿”老师课的同学的学号、姓名

SELECT id,NAME FROM Student student
WHERE id NOT IN
(
SELECT sc.student_id  FROM Sc sc ,Course course ,Teacher teacher
WHERE sc.course_id=course.id AND course.teacher_id=teacher.id

AND teacher.name='马三立'
)

6.	查询学过编号1并且也学过编号5课程的同学的学号、姓名；


select  student.id,student.name from Student student ,Sc sc where student.id=sc.student_id
and sc.course_id=1
and exists
(
select * from Sc sc1
where  student.id=sc1.student_id and sc1.course_id=5
)

或者 ：
SELECT  student.id,student.name FROM Student student ,Sc sc ,Course course WHERE student.id=sc.student_id
AND sc.course_id=course.id
AND course.name='math'
AND EXISTS
(
SELECT * FROM Sc sc1 ,Course course
WHERE  student.id=sc1.student_id

 AND sc1.course_id=course.id
 AND course.name='ai'
)

7.	查询学过“马三立”老师所教的 所有课的同学的学号、姓名；

SELECT id,NAME FROM Student student
WHERE student.id IN

(
SELECT sc.student_id  FROM  Sc sc ,Course course,Teacher teacher
WHERE sc.course_id=course.id
AND course.teacher_id=teacher.id
AND teacher.name='马三立'
GROUP BY sc.student_id

HAVING  COUNT( DISTINCT course.id)=

(
SELECT COUNT( DISTINCT course.id)  FROM  Sc sc ,Course course,Teacher teacher
WHERE sc.course_id=course.id
AND course.teacher_id=teacher.id
AND teacher.name='马三立'
)
)

或者
SELECT id ,NAME FROM Student student WHERE student.id
IN
(

SELECT DISTINCT sc.student_id
 FROM Sc sc,Course course WHERE sc.course_id=course.id AND sc.course_id

IN
(
SELECT  DISTINCT course.id  FROM  Course course,Teacher teacher
WHERE
course.teacher_id=teacher.id
AND teacher.name='马三立'
)

)


8、	查询课程编号“math”的成绩比课程编号“english”课程低的所有同学的学号、姓名；

SELECT id,NAME FROM  Student student WHERE id
IN
(
SELECT student_id FROM
(
SELECT sc.student_id,sc.score score1  ,(SELECT  sc2.score FROM Sc sc2 ,Course course WHERE sc2.student_id=sc.student_id AND sc2.course_id=course.id
AND course.name='english') score2

FROM  Sc sc ,Course course WHERE sc.course_id=course.id AND course.name='math'
)a WHERE score1 <score2

)

或者

SELECT a.name FROM Student a WHERE a.id IN
(
SELECT  a.student_id FROM

 (SELECT a.student_id ,a.score FROM Sc a ,Course b WHERE a.course_id=b.id AND  b.name='math' )a
,
(SELECT a.student_id,a.score FROM Sc a ,Course b WHERE a.course_id=b.id AND  b.name='english')b

WHERE a.student_id=b.student_id

AND  a.score< b.score
)

9. 	查询所有课程成绩小于70分的同学的学号、姓名；

即，不在成绩大于70的学生名单里
SELECT NAME,id FROM Student student
WHERE student.id  NOT IN
(
SELECT sc.student_id FROM Sc sc
WHERE sc.score>=70
)

或者  在最大分数小于70的学生名单里

SELECT NAME,id FROM Student student
WHERE student.id IN
(
SELECT sc.student_id FROM Sc sc
GROUP BY sc.student_id
HAVING MAX(sc.score)<70
)

10.查询没有学全所有课的同学的学号、姓名

 即学的课的groupby 的数量比总课数小
select sc.student_id , student.name from Sc sc ,Student student
where sc.student_id=student.id
group by sc.student_id
having count(sc.course_id)<
(select count( id) from Course course)

11.查询至少有一门课与学号为“1”的同学所学相同的同学的学号和姓名；

即 与学号为“1”的同学所学相同的同学的学号和姓名


SELECT student.id,student.name FROM Student student WHERE student.id
IN

(

SELECT  DISTINCT sc.student_id FROM Sc sc WHERE

 sc.course_id

IN
(
SELECT course_id FROM Sc sc WHERE sc.student_id=3
)
)

12.查询至少学过学号为“4” 同学所有门课的其他同学学号和姓名

有点复杂
即 存在  学号为“4” 的集合里，找到Sc 的course
二表自关联,一表条件


SELECT DISTINCT sc.student_id FROM Sc sc WHERE
EXISTS
(SELECT  course_id  FROM Sc sc2 WHERE course_id=4
 AND course_id IN ( SELECT course_id FROM Sc sc3 WHERE sc3.student_id=sc.student_id ) )

 13 查询把“SC”表中“霍金”老师教的课程的平均成绩；

SELECT student.name,AVG(sc.score)  FROM Student student, Sc sc ,Course course ,Teacher teacher
 WHERE sc.course_id=course.id
AND student.id=sc.student_id
AND course.teacher_id=teacher.id
 AND teacher.name='霍金'
GROUP BY student.id

14.查询和“1”号的同学学习的课程完全相同的其他同学学号和姓名；

SELECT sc.student_id,student.name FROM  Sc sc ,Student student  WHERE
sc.student_id=student.id AND
 sc.course_id IN (
 SELECT course_id FROM Sc WHERE  student_id=1
 )
 AND
sc.student_id<>1
GROUP BY sc.student_id
HAVING COUNT( DISTINCT sc.course_id)=
(
SELECT COUNT( DISTINCT sc2.course_id) FROM Sc sc2 WHERE sc2.student_id=1

)

15. 查询学习“霍金”老师课的SC表记录；
SELECT *FROM Sc sc  ,Teacher teacher WHERE sc.course_id=teacher.id AND teacher.name='霍金'
16.
按平均成绩从高到低显示所有学生的“math”、“physics”、“english”三门的课程成绩，按如下形式显示：学生ID,,math,physics,english,有效课程数,有效平均分

SELECT sc.student_id,
(SELECT sc2.score FROM Sc sc2 WHERE sc2.student_id=sc.student_id AND sc2.course_id='1'   ) math,
(SELECT sc2.score FROM Sc sc2 WHERE sc2.student_id=sc.student_id AND sc2.course_id='2'   ) physics,
(SELECT sc2.score FROM Sc sc2 WHERE sc2.student_id=sc.student_id AND sc2.course_id='3'   ) english,

COUNT(sc.course_id),
AVG(sc.score)
  FROM Sc sc
GROUP BY sc.student_id
ORDER BY AVG(sc.score)

17.
查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
SELECT sc.course_id,MAX(sc.score),MIN(sc.score)  FROM Sc sc  GROUP BY sc.course_id
或者


SELECT L.course_id AS 课程ID,L.score AS 最高分,R.score AS 最低分  ,
L.student_id AS  max_sid,R.student_id  AS min_sid ,(SELECT NAME FROM Student a WHERE a.id=L.student_id) 最高学生,

(SELECT NAME FROM Student b WHERE b.id=R.student_id) 最低学生


 FROM Sc L ,Sc AS R
WHERE L.course_id = R.course_id
AND
L.score = (SELECT MAX(IL.score)
         FROM Sc AS IL
                 WHERE L.course_id = IL.course_id

                          GROUP BY IL.course_id)
 AND
 R.Score = (SELECT MIN(IR.score)
                   FROM Sc AS IR
                  WHERE R.course_id = IR.course_id

                  GROUP BY IR.course_id
                   );

