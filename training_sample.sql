#Write SQL queries for the below questions after loading the sample exercise data.

#Queries that uses “students” table:

# 1. Select all the students
select * from students

# 2. Select all the students whose names starts with “H”
SELECT * FROM students WHERE name LIKE "H%"

# 3. Select all the students whose name has the alphabet “a”
SELECT * FROM students WHERE name LIKE "%a%"

# 4. Select all the students and list the results sorted in alphabetical order(a-z).
SELECT * from students ORDER by name ASC

# 5. List the first “2” students with the results sorted in the alphabetical order(a-z).
SELECT * from students ORDER by name ASC LIMIT 0,2

# 6. List the next “2” students(3rd and 4th) when they are sorted in the alphabetical order.
SELECT * from students ORDER by name ASC LIMIT 2,2

# Queries that uses “marks” table:

# 7. Select the students who has not appeared in the annual exams.
#Format: All columns of the “marks” table.
SELECT * FROM marks WHERE annual is NULL

# 8. Select the students who has not appeared in the annual exams during the year “2005”.
#Format: student_id, subject_id, year
SELECT student_id, subject_id, year FROM marks WHERE annual is NULL and year = 2005

# 9. Select the students who has appeared in one of the exams - quarterly, half_yearly or annual.
#Format: student_id, subject_id, year
SELECT student_id, subject_id, year FROM marks WHERE annual is NOT NULL or quarterly is NOT NULL or half_yearly is NOT NULL

# 10. Select the students who has scored more than 90 in all the exams - quarterly, half_yearly and annual.
#Format: student_id, subject_id, year, quarterly, half_yearly, annual
SELECT student_id, subject_id, year, quarterly, half_yearly, annual FROM marks WHERE annual > 90 and quarterly > 90 and half_yearly > 90;

# 11. List the average marks(in quarterly, half_yearly & annual) for each subject scored for the year.
#Format: student_id, subject_id, average, year
SELECT student_id, subject_id, AVG(quarterly) as quarterly, AVG(half_yearly) as half_yearly, AVG(annual) as annual, year from marks group by subject_id, year, student_id;

# 12. List the average marks(in quarterly, half_yearly & annual) for each subject scored for the years 2003 & 2004
#Format: student_id, subject_id, average, year
SELECT student_id, subject_id, AVG(quarterly) as quarterly, AVG(half_yearly) as half_yearly, AVG(annual) as annual, year from marks where year=2003 or year=2004 group by subject_id, year, student_id;

# Write the queries from the "marks" table using inner join with the table "students" table to replace student_id with name. 
select m.id, s.name, m.subject_id, m.quarterly, m.annual, m.year, m.grade from marks as m inner join students as s on m.student_id = s.id;

#List the students who didn’t appear for any exams.
#Format: name
select s.name from marks as m inner join students as s on m.student_id = s.id where m.quarterly is NULL and m.half_yearly is NULL and m.annual is NULL;

# Find the total marks scored by each students in the annual exams. If the student hasn’t appeared for any annual exam, he should still be listed with total marks scored as “0”.
# Format: name, marks, year
select s.name, SUM(m.annual) as marks, m.year from marks as m inner join students as s on m.student_id = s.id group by m.student_id, m.year;

# List the students with the total marks scored in quarterly from all the subjects they had appeared during the year 2003.
# Format: name, total, grade
select s.name, SUM(m.quarterly) as marks, m.year from marks as m inner join students as s on m.student_id = s.id where m.year = 2003 group by m.student_id, m.year;

#List the 9th and 10th grade students who received more than 3 medals.
#Format: name, grade, no_of_medals
select s.name, m.grade, count(m.student_id) from medals as m inner join students as s on m.student_id = s.id group by m.student_id, m.grade having count(student_id) > 2;

#List the students who got less than 2 medals. This should also include the students who has not won any medals.
#Format: name, grade, no_of_medals
select s.name, m.grade, count(m.student_id) as no_of_medals from students as s left join medals as m on m.student_id = s.id group by m.student_id, m.grade, s.name having count(student_id) < 2;

#List the students who has not yet received any medals but scored more than 90 marks in all the subjects in the annual exam for that year.
#Format: name, year
select s.name, m.year from marks as m inner join students as s on s.id = m.student_id where annual > 40 and student_id in (select s.id from students as s left join medals as m on m.student_id = s.id group by m.student_id, m.grade, s.name having count(student_id) = 0)  group by student_id, year having count(*) > 4;

#List the records from the medals table for the students who had won more than 3 medals.
#Format: name, game_id, medal_won, year, grade
select s.name, m.game_id, m.medal_won, m.year, m.grade from students as s inner join medals as m on m.student_id = s.id where m.student_id in (select student_id from medals group by student_id having count(student_id) > 3);

#List the number of medals and percentage of marks(based on total for the 5 subjects) scored in each year.
#Format: name, medals, quarterly_per, half_yearly_per, annual_per, year, grade
 select s.name, s.quarterly, s.half_yearly, s.annual, s.year, m.no_of_medals from (SELECT m.student_id, s.name as name, AVG(quarterly) as quarterly, AVG(half_yearly) as half_yearly, AVG(annual) as annual, year from marks as m inner join students as s on s.id = m.student_id group by year, student_id) as s left join (select s.id as id, m.year, count(m.student_id) as no_of_medals from students as s left join medals as m on m.student_id = s.id group by m.student_id, m.year, s.name having count(student_id)>=0)  as m on s.student_id = m.id and s.year = m.year;


#Lets assign some rating for the total marks scored - S(450-500), A(400-449), B(350-399), C(300-349), D(250,299), E(200-249), F(below 200). List the students with the grade obtained in each year for each exam(quarterly, half-yearly and annual)
#Format: name, quarterly_rating, half_yearly_rating, annual_rating, year, grade
 select s.name, m.year, m.grade, case when sum(m.quarterly) between 450 and 500 then "s" when sum(m.quarterly) between 400 and 449 then "A" when sum(m.quarterly) 
 between 350 and 399 then "B" when sum(m.quarterly) between 300 and 349 then "C" when sum(m.quarterly) between 250 and 299 then "D" when sum(m.quarterly) between 200 and 249 then "E" else "F" end as quarterly_rating, case when sum(m.half_yearly) between 450 and 500 then "s" when sum(m.half_yearly) between 400 and 449 then "A" when sum(m.half_yearly) 
 between 350 and 399 then "B" when sum(m.half_yearly) between 300 and 349 then "C" when sum(m.half_yearly) between 250 and 299 then "D" when sum(m.half_yearly) between 200 and 249 then "E" else "F" end as half_yearly_rating, case when sum(m.annual) between 450 and 500 then "s" when sum(m.annual) between 400 and 449 then "A" when sum(m.annual) 
 between 350 and 399 then "B" when sum(m.annual) between 300 and 349 then "C" when sum(m.annual) between 250 and 299 then "D" when sum(m.annual) between 200 and 249 then "E" else "F" end as annual_rating 
    from students as s inner join marks as m on m.student_id = s.id group by m.student_id, m.year order by m.year;


#day 4
update marks set quarterly = 0 where quarterly is NULL;
update marks set half_yearly = 0 where half_yearly is NULL;
update marks set annual = 0 where annual is NULL;
alter table marks modify quarterly NOT NULL;
alter table marks modify half_yearly int NOT NULL;
alter table marks modify annual int NOT NULL;



select s.name, s.std_id, s.quarterly, s.half_yearly, s.annual, s.year, m.no_of_medals from (SELECT m.student_id as std_id, s.name as name, AVG(quarterly) as quarterly, AVG(half_yearly) as half_yearly, AVG(annual) as annual, year from marks as m inner join students as s on s.id = m.student_id group by year, student_id) as s left join (select s.id as id, m.year, count(m.student_id) as no_of_medals from students as s left join medals as m on m.student_id = s.id group by m.student_id, m.year, s.name having count(student_id)>=0)  as m on s.std_id = m.id and s.year = m.year;







 insert into students_summary (student_id, student_name, year, percentage, no_of_medals) select s.std_id as student_id, s.name as student_name, s.year as year, s.annual as percentage, m.no_of_medals as no_of_medals from (SELECT m.student_id as std_id,
 s.name as name, AVG(quarterly) as quarterly, AVG(half_yearly) as half_yearly, AVG(annual) as annual, year from marks as m inner join 
 students as s on s.id = m.student_id group by year, student_id) as s left join (select s.id as id, m.year, count(m.student_id) as no_of_medals
  from students as s left join medals as m on m.student_id = s.id group by m.student_id, m.year, s.name having count(student_id)>=0)  as m on s.std_id = m.id and
   s.year = m.year;
