-- Populate teachers
INSERT INTO teachers (first_name, last_name, email, hire_date) VALUES
('John', 'Smith', 'john.smith@example.com', '2020-08-15'),
('Jane', 'Doe', 'jane.doe@example.com', '2019-05-20');

-- Populate courses
INSERT INTO courses (title, description, start_date, end_date, teacher_id) VALUES
('Introduction to GraphQL', 'Learn the basics of GraphQL and its ecosystem.', '2023-09-01', '2023-12-15', 1),
('Advanced SQL', 'Deep dive into complex SQL queries and database design.', '2023-10-01', '2024-01-31', 2),
('Web Development with React', 'Build dynamic web applications using React.', '2023-09-15', '2024-02-28', 1);

-- Populate students
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('Alice', 'Johnson', 'alice.j@example.com', '2023-08-25'),
('Bob', 'Williams', 'bob.w@example.com', '2023-08-26'),
('Charlie', 'Brown', 'charlie.b@example.com', '2023-08-27'),
('Diana', 'Miller', 'diana.m@example.com', '2023-08-28'),
('Edward', 'Davis', 'edward.d@example.com', '2023-08-29'),
('Fiona', 'Garcia', 'fiona.g@example.com', '2023-08-30'),
('George', 'Rodriguez', 'george.r@example.com', '2023-08-31'),
('Hannah', 'Martinez', 'hannah.m@example.com', '2023-09-01'),
('Ivan', 'Lopez', 'ivan.l@example.com', '2023-09-02'),
('Jessica', 'Perez', 'jessica.p@example.com', '2023-09-03');

-- Populate student enrollments
INSERT INTO student_enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2023-09-01'), -- Alice in GraphQL
(2, 1, '2023-09-01'), -- Bob in GraphQL
(3, 2, '2023-10-01'), -- Charlie in Advanced SQL
(4, 3, '2023-09-15'), -- Diana in Web Dev
(5, 1, '2023-09-01'), -- Edward in GraphQL
(6, 2, '2023-10-01'), -- Fiona in Advanced SQL
(7, 3, '2023-09-15'), -- George in Web Dev
(8, 1, '2023-09-01'), -- Hannah in GraphQL
(9, 2, '2023-10-01'), -- Ivan in Advanced SQL
(10, 3, '2023-09-15'), -- Jessica in Web Dev
(1, 2, '2023-10-01'), -- Alice also in Advanced SQL
(2, 3, '2023-09-15'); -- Bob also in Web Dev