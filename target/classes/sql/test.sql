CREATE TABLE employee_commuting_time(emp_id int(10) NOT null PRIMARY KEY, in_time TIMESTAMP, out_time TIMESTAMP, is_checked_in boolean DEFAULT 1);

INSERT INTO employee_commuting_time(emp_id,in_time) VALUES (1 , CURRENT_TIMESTAMP);
INSERT INTO employee_commuting_time(emp_id,in_time) VALUES (2 , CURRENT_TIMESTAMP);