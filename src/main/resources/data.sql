INSERT INTO student (id, name) VALUES (1, 'Alice');
INSERT INTO student (id, name) VALUES (2, 'Bob');
INSERT INTO student (id, name) VALUES (3, 'Charlie');

INSERT INTO course (id, title, instructor) VALUES (1, 'Spring Boot Basics', 'Dr. Smith');
INSERT INTO course (id, title, instructor) VALUES (2, 'Java Programming', 'Prof. Johnson');
INSERT INTO course (id, title, instructor) VALUES (3, 'Database Design', 'Dr. Brown');


INSERT INTO enrollment (id, enrollment_date, student_id, course_id)
VALUES (1, CURRENT_DATE, 1, 1);

INSERT INTO enrollment (id, enrollment_date, student_id, course_id)
VALUES (2, CURRENT_DATE, 1, 2);

